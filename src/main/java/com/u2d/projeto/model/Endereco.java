package com.u2d.projeto.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "TB002_ENDERECO")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 166308449528778915L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CO_ENDERECO")
	private Long id;
	
	@Column(name = "CO_CEP")
	private String cep;
	
	@Column(name = "NO_LOGRADOURO")
	private String logradouro;
	
	@Column(name = "NO_COMPLEMENTO")
	private String complemento;
	
	@Column(name = "NO_BAIRRO")
	private String bairro;
	
	@Column(name = "NO_CIDADE")
	private String cidade;
	
	@Column(name = "NO_UF")
	private Character uf;
	
	@Column(name = "CO_IBGE")
	private String codigoIBGE;
	
	@Tolerate
	public Endereco() {}
}
