package br.com.fabricadeprogramador.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Virmerson Bento dos Santos on 11/29/16.
 */

@Entity
@Data
public class Empresa {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private String cnpj;
    private String razaosocial;
    @JsonIgnore
    private String loja;
    private String endereco;
    @JsonIgnore
    private String telefone;
    @JsonIgnore
    private String email;

    
    
    
    
    public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	//@Lob
    @JsonIgnore
    private byte[] logo;
    
    
    
    public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Empresa(String razaosocial, String endereco){
    super();
    this.razaosocial = razaosocial;
    this.endereco = endereco;
    }
    
    public Empresa(){
    	// TODO Auto-generated constructor stub
    }


}
