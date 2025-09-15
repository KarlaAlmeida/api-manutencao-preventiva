package br.edu.infnet.karlaapitdd.model.service;

import br.edu.infnet.karlaapitdd.model.domain.clients.ViaCepFeignClient;
import br.edu.infnet.karlaapitdd.model.domain.entities.Endereco;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final ViaCepFeignClient viaCepFeignClient;

    public EnderecoService(ViaCepFeignClient viaCepFeignClient) {
        this.viaCepFeignClient = viaCepFeignClient;
    }

    public Endereco obterEnderecoPorCep(String cep){
        return viaCepFeignClient.findByCep(cep);
    }
}
