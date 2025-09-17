package br.edu.infnet.karlaapitdd;

import br.edu.infnet.karlaapitdd.model.domain.entities.Endereco;
import br.edu.infnet.karlaapitdd.model.service.EnderecoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EnderecoLoader implements ApplicationRunner {

    private final EnderecoService enderecoService;

    public EnderecoLoader(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            Endereco endereco = enderecoService.obterEnderecoPorCep("59150015");

            System.out.println("[RESULTADO] MEU CEP: " + endereco.getCep());
            System.out.println("[RESULTADO] MEU LOGRADOURO: " + endereco.getLogradouro());
            System.out.println("[RESULTADO] MEU COMPLEMENTO: " + endereco.getComplemento());
            System.out.println("[RESULTADO] MEU BAIRRO: " + endereco.getBairro());
            System.out.println("[RESULTADO] MEU MUNICÍPIO: " + endereco.getLocalidade());
            System.out.println("[RESULTADO] MEU UF: " + endereco.getUf());
            System.out.println("[RESULTADO] MINHA LATITUDE: " + endereco.getLatitude());
            System.out.println("[RESULTADO] MINHA LONGITUDE: " + endereco.getLongitude());
        }catch (feign.RetryableException e) {
            System.err.println("[ATENÇÃO] Não foi possível conectar ao serviço de geolocalização. " +
                    "Verifique se as APIs viacep e openStreetMap estão em execução. Detalhes: " + e.getMessage());
        }catch (Exception e) {
            System.err.println("[ERRO] Um erro inesperado ocorreu no EnderecoLoader: " + e.getMessage());
        }
    }
}
