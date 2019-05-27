package com.u2d.projeto.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Builder
@Table(name = "TB001_CONTATO")
public class Contato implements Serializable{

	private static final long serialVersionUID = -5638331205488770864L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CO_CONTATO")
	private Long id;
	
	@NotNull
	@Size(max=11)
	@Column(name = "CO_CPF")
	private String cpf;
	
	@NotNull
	@Size(max=100)
	@Column(name = "NO_NOME")
	private String nomeContato;
	
	@Size(max=11)
	@Column(name = "NU_TELEFONE_MOVEL")
	private String telefoneMovel;
	
	@Size(max=11)
	@Column(name = "NU_TELEFONE_FIXO")
	private String telefoneFixo;
	
	@Size(max=100)
	@Column(name = "NO_EMAIL")
	private String email;
	
	@Tolerate
	public Contato() {
	}
}
