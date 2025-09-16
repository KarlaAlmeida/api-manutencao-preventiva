package br.edu.infnet.karlaapitdd.model.service;

import br.edu.infnet.karlaapitdd.model.domain.clients.OpenStreetMapFeignClient;
import br.edu.infnet.karlaapitdd.model.domain.clients.ViaCepFeignClient;
import br.edu.infnet.karlaapitdd.model.domain.entities.Endereco;
import br.edu.infnet.karlaapitdd.model.domain.entities.Geolocalizacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final ViaCepFeignClient viaCepFeignClient;
    private final OpenStreetMapFeignClient openStreetMapFeignClient;

    public EnderecoService(ViaCepFeignClient viaCepFeignClient,
                           OpenStreetMapFeignClient openStreetMapFeignClient) {
        this.viaCepFeignClient = viaCepFeignClient;
        this.openStreetMapFeignClient = openStreetMapFeignClient;
    }

    public Endereco obterEnderecoPorCep(String cep){
        Endereco endereco = viaCepFeignClient.findByCep(cep);

        if (endereco != null) {
            String query = endereco.getLogradouro() + ", " + endereco.getLocalidade() + ", " + endereco.getUf();
            List<Geolocalizacao> geolocalizacoes = openStreetMapFeignClient.search(query, "jsonv2", 10);

            if (geolocalizacoes != null && !geolocalizacoes.isEmpty()) {
                Geolocalizacao geolocalizacao = geolocalizacoes.get(0);
                endereco.setLatitude(geolocalizacao.getLat());
                endereco.setLongitude(geolocalizacao.getLon());
            }
        }

        return endereco;
    }
}
