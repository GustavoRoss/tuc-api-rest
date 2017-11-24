package br.com.fabricadeprogramador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Localizacao {
	@Id
	@GeneratedValue
	private Long id;

	private double latitude;
	private double longitude;
}
