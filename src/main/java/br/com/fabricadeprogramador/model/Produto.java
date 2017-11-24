package br.com.fabricadeprogramador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Produto {
	@Id
	@GeneratedValue
	private Integer id;
    private String codigoBarra;
    private String descricao;
    private Double valor;
	public Produto(String codigoBarra, String descricao, Double valor) {
		super();
		this.codigoBarra = codigoBarra;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
}
