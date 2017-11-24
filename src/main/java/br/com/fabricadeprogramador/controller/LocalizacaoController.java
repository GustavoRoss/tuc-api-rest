package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.model.Localizacao;
import br.com.fabricadeprogramador.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocalizacaoController {

    @Autowired
    LocalizacaoRepository repository;

    @GetMapping("/localizacoes")
    private List<Localizacao> buscarLocalizacoes() {
        return repository.findAll();

    }

    @PostMapping("/localizacoes")
    private Localizacao salvar(@RequestBody Localizacao localizacao) {
        return repository.save(localizacao);
    }
}
