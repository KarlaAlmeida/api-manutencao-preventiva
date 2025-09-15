package br.edu.infnet.karlaapitdd.controller;


import br.edu.infnet.karlaapitdd.model.domain.entities.Endereco;
import br.edu.infnet.karlaapitdd.model.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> obterPorCep(@PathVariable String cep){

        return ResponseEntity.ok(enderecoService.obterEnderecoPorCep(cep));
    }
}
