package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fabricadeprogramador.model.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	@Query("select p from Produto p " +
			"where upper(p.descricao) like concat('%', upper(:content), '%') or p.codigoBarra=:content")
	List<Produto> buscarProdutosPorCodigoOuDescricao(@Param("content") String content);

	@Query("select p from Produto p where p.codigoBarra=:codigo")
	Produto buscarPorCodigoBarra(@Param("codigo") String codigo);

}
