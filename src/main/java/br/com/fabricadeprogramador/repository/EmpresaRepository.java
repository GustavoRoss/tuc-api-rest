package br.com.fabricadeprogramador.repository;

import br.com.fabricadeprogramador.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	@Query("select e from Empresa e")
	Empresa buscar();
	
	//@Query("select e from Empresa e where e.id=:cod")
	//Empresa buscar(@Param("cod") Integer id);

}