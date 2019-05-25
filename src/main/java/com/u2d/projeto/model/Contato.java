package com.u2d.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB002_CONTATO")
public class Contato implements Serializable{

	private static final long serialVersionUID = -5638331205488770864L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_CONTATO")
	private Long id;
	
	@Column(name = "CO_CPF")
	private String cpf;
	
	@Column(name = "CO_CONTATO")
	private String nomeContato;
	
	@Column(name = "NU_TELEFONE_MOVEL")
	private String telefoneMovel;
	
	@Column(name = "NU_TELEFONE_FIXO")
	private String telefoneFixo;
	
	@Column(name = "NO_EMAIL")
	private String email;

}
