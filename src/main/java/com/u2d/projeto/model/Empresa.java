package com.u2d.projeto.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB001_EMPRESA")
public class Empresa implements Serializable{

	private static final long serialVersionUID = -2059101010501651601L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_EMPRESA")
	private Long id;
	
	@Column(name = "CO_CNPJ")
	private String cnpj;
	
	@Column(name = "NO_RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name = "NO_NOME_FANTASIA")
	private String nomeFantasia;
	
	@Column(name = "IC_SITUACAO")
	private Character situacao;
	
	@Column(name = "NO_CLASSIFICACAO_TRIBUTARIA")
	private String classificacaoTributaria;
	
	@Column(name = "NO_NATUREZA_JURIDICA")
	private String naturezaJuridica;
	
	@Column(name = "IC_REGISTRO_ELETRONICO_EMPREGADO")
	private Character registroEletronicoEmpregado;
	
	@Column(name = "IC_COOPERATIVA")
	private Character cooperativa;
	
	@Column(name = "IC_CONSTRUTORA")
	private Character construtora;
	
	@Column(name = "IC_DESONERACAO_FOLHA")
	private Character desoneracaoFolha;
	
	@Column(name = "IC_ENTIDADE_EDUCATIVA")
	private Character entidadeEducativa;
	
	@Column(name = "IC_EMPRESA_TRABALHO_TEMPORARIO")
	private Character empresaTrabalhoTemporario;
	
	@Column(name = "IC_SITUACAO_PESSOA_JURIDICA")
	private Character situacaoPessoaJuridica;
	
	@Column(name = "DT_ABERTURA")
	private LocalDate dataAbertura;
	
	@Column(name = "NO_TIPO_EMPRESA")
	private String tipoEmpresa;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENDERECO_COD")
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTATO_COD")
	private Contato contato;
}
