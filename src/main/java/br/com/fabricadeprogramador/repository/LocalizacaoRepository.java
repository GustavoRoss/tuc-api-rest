package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.model.Localizacao;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {

}
