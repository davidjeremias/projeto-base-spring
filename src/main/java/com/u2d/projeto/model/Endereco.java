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
	
	@NotNull
	@Size(max=10)
	@Column(name = "CO_CEP")
	private String cep;
	
	@NotNull
	@Size(max=100)
	@Column(name = "NO_LOGRADOURO")
	private String logradouro;
	
	@Size(max=100)
	@Column(name = "NO_COMPLEMENTO")
	private String complemento;
	
	@NotNull
	@Size(max=100)
	@Column(name = "NO_BAIRRO")
	private String bairro;
	
	@NotNull
	@Size(max=100)
	@Column(name = "NO_CIDADE")
	private String cidade;
	
	@NotNull
	@Size(max=2)
	@Column(name = "NO_UF")
	private String uf;
	
	@NotNull
	@Size(max=20)
	@Column(name = "CO_IBGE")
	private String codigoIBGE;
	
	@Tolerate
	public Endereco() {}
}
