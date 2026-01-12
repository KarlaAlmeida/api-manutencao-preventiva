# API Obtenção de endereço por CEP e georreferencimento

## Visão Geral do Projeto
Esta funcionalidade foi desenvolvida em Spring Boot para consumo e orquestração de dados de APIs externas.

A API expõe um endpoint para consulta de endereços a partir de um CEP. A implementação consome dados da API [ViaCEP](https.viacep.com.br) para obter os dados do endereço e, em seguida, orquestra uma chamada para a API [OpenStreetMap](https.openstreetmap.org) para obter os dados de geolocalização (latitude e longitude).
O objetivo desta funcionalidade é habilitar novas funcionalidades no sistema, tais como a identificação da distância dos técnicos, em função das coordenadas geográficas, em relação ao ativo para acionar o que estiver mais próximo da ocorrência.

###
Este projeto atua como um módulo de endereço georrefenciado que é consumido, por meio do OpenFeign, pelo sistema principal api-gestao-rede-eletrica, no qual os ativos recebem o endereço georreferenciado.

## Como executar

Para executar o projeto, utilize o seguinte comando Maven:

```bash
mvn spring-boot:run
```

## Consumidor

Esta API é consumida pelo projeto [api-gestao-rede-eletrica](https://github.com/usuario/api-gestao-rede-eletrica).

## Endpoints

### Obter Endereço por CEP

Recupera os detalhes de um endereço, incluindo geolocalização, a partir de um CEP.

- **URL**: `/api/enderecos/{cep}`
- **Método**: `GET`
- **Parâmetros da URL**:
  - `cep=[string]` (obrigatório) - O CEP para consulta (deve conter 8 dígitos).

- **Exemplo de Resposta de Sucesso**:

  **Código**: `200 OK`
  **Conteúdo**:
  ```json
  {
      "cep": "22290-240",
      "logradouro": "Avenida Pasteur",
      "complemento": "458",
      "bairro": "Urca",
      "localidade": "Rio de Janeiro",
      "uf": "RJ",
      "ibge": "3304557",
      "gia": "",
      "ddd": "21",
      "siafi": "6001",
      "latitude": "-22.9531",
      "longitude": "-43.1673"
  }
  ```

- **Exemplo de Resposta de Erro**:

  **Código**: `404 NOT FOUND`
  **Conteúdo**:
  ```json
  {
      "timestamp": "2024-07-25T14:30:00.000+00:00",
      "status": 404,
      "error": "Not Found",
      "message": "CEP não encontrado: 99999999",
      "path": "/api/enderecos/99999999"
  }
  ```
