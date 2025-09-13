# API TDD - Gestão de Ordens de Serviço Preventivas

## Visão Geral do Projeto

Este projeto foi desenvolvido utilizando a metodologia TDD (Test-Driven Development - Desenvolvimento Orientado a Testes) e tem como principal funcionalidade o cálculo do custo total de Ordens de Serviço (O.S.) de manutenção preventiva para uma rede elétrica.

A aplicação permite criar uma O.S., associar um ou mais serviços a ela (cada um com seu ativo, tipo de serviço e quantidade) e, em seguida, calcular o valor total com base em uma tabela de custos pré-definida.

### Integração com o projeto `api-gestao-rede-eletrica`

Este projeto (`karlaapitdd`) atua como um **módulo de cálculo de custos** que foi desenvolvido de forma isolada e orientada a testes para garantir a máxima qualidade e corretude da lógica de negócio.

A `api-gestao-rede-eletrica` é o sistema principal que gerencia o ciclo de vida completo dos ativos, equipes, e ordens de serviço. A ideia é que a funcionalidade desenvolvida aqui seja integrada à `api-gestao-rede-eletrica` como um microsserviço. Quando a API principal precisar calcular o custo de uma O.S. de manutenção preventiva, ela consumirá os serviços e a lógica de negócio implementados neste projeto, garantindo que os cálculos sejam precisos e confiáveis, graças à cobertura de testes rigorosa obtida com o TDD.

## Principais Classes

### Classes de Modelo (Model)

-   **`OrdemServicoPreventiva`**: Representa a Ordem de Serviço em si. Contém os dados do técnico responsável e uma lista de serviços a serem executados.
-   **`ServicoPreventiva`**: Modela um serviço específico dentro da O.S. Contém o `Ativo` que receberá a manutenção, a `quantidade` de intervenções e o `TipoServicoPreventiva`.
-   **`Ativo`**: Representa um ativo da rede elétrica, como um `POSTE` ou `TRANSFORMADOR`. Possui um código, tipo, status e data de instalação.
-   **`TabelaCustoPreventiva`**: Classe utilitária estática que armazena o mapeamento de custos. Ela define o valor unitário para cada `TipoServicoPreventiva` aplicado a um determinado `TipoAtivo`.

### Classe de Serviço (Service)

-   **`OrdemServicoPreventivaService`**: Contém a principal lógica de negócio da aplicação.
    -   `calcularCustoTotal()`: Itera sobre a lista de `ServicoPreventiva` de uma O.S., calcula o custo de cada um e retorna a soma total.
    -   `validarOrdemServicoPreventiva()`: Verifica se uma O.S. possui os dados mínimos para ser considerada válida (como nome do técnico e lista de serviços não vazia).

## Cenários de Teste Unitário (Ciclo Red-Green-Refactor)

A seguir, são descritos 3 cenários de teste criados para guiar o desenvolvimento da funcionalidade de cálculo de custos, seguindo o ciclo TDD.

### 1. Cenário: Calcular custo para O.S. com um único serviço

-   **Objetivo**: Garantir que o sistema calcule corretamente o custo total de uma O.S. que contém apenas um serviço.

-   **Ciclo TDD**:
    -   **RED**: O primeiro passo foi escrever o teste `deveCalcularValorTotal_quandoOrdemServicoPreventivaPossuirUmItem`. Criamos uma O.S. com um serviço (ex: 2 inspeções visuais em um poste, com custo unitário de R$ 10,00). A asserção do teste esperava um total de R$ 20,00. Ao rodar o teste, ele falhou (ficou "vermelho"), pois o método `calcularCustoTotal` ainda não tinha sido implementado e lançava uma UnsupportedOperationException.
    -   **GREEN**: Para fazer o teste passar (ficar "verde"), implementamos a lógica mais simples possível no método `calcularCustoTotal`. Isso envolveu iterar pela lista de serviços, chamar o método `calcularCusto()` de cada serviço (que também foi criado nesse ciclo) e somar os resultados.
    -   **REFACTOR**: Com o teste passando, analisamos o código. A primeira versão poderia ter alguma complexidade ou código duplicado. Nesta fase, refatoramos o código para torná-lo mais limpo e legível (por exemplo, usando Streams do Java 8 em vez de um loop `for`, ou garantindo que os nomes das variáveis eram claros), sempre rodando os testes para garantir que a funcionalidade não foi quebrada.

### 2. Cenário: Calcular custo para O.S. com múltiplos serviços

-   **Objetivo**: Verificar se o sistema é capaz de somar os custos de múltiplos serviços diferentes dentro da mesma O.S.

-   **Ciclo TDD**:
    -   **RED**: Escrevemos o teste `deveCalcularValorTotal_quandoOrdemServicoPreventivaPossuirVariosServicos`. Nele, criamos uma O.S. com dois serviços distintos (ex: inspeção em um poste e reaperto em um transformador). O teste esperava a soma dos custos de ambos. Ele falhou inicialmente, pois o método `calcularCustoTotal` ainda não tinha sido implementado e lançava uma UnsupportedOperationException.
    -   **GREEN**: Ajustamos a implementação do método `calcularCustoTotal` para garantir que ele iterava corretamente por todos os serviços na lista e acumulava a soma de forma correta, fazendo o teste passar.
    -   **REFACTOR**: Após o teste passar, revisamos o código em busca de melhorias. Por exemplo, garantimos que a forma de acumular os valores (`BigDecimal`) era a mais eficiente e que não havia perda de precisão. O código foi otimizado para legibilidade e manutenção.

### 3. Cenário: Retornar zero para O.S. sem serviços

-   **Objetivo**: Assegurar que, para uma Ordem de Serviço que não tenha nenhum serviço associado, o custo total calculado seja zero.

-   **Ciclo TDD**:
    -   **RED**: Criamos o teste `deveRetornarZero_quandoOrdemServicoPreventivaNaoPossuirServicos`. Nele, uma O.S. foi criada com uma lista de serviços vazia. A asserção esperava que o resultado fosse `BigDecimal.ZERO`. O teste falhou, pois o método `calcularCustoTotal` ainda não tinha sido implementado e lançava uma UnsupportedOperationException.
    -   **GREEN**: Adicionamos uma verificação no início do método `calcularCustoTotal` para checar se a lista de serviços era nula ou vazia. Se fosse, o método retornaria `BigDecimal.ZERO` imediatamente. Isso fez o teste passar.
    -   **REFACTOR**: Com o teste verde, o código foi revisado. A verificação adicionada foi analisada para garantir que era a forma mais idiomática e limpa de tratar essa condição em Java, mantendo o método conciso e claro.
