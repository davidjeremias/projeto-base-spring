package com.u2d.projeto.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;
import lombok.experimental.Tolerate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "TB005_EMPRESA")
public class Empresa implements Serializable{

	private static final long serialVersionUID = -2059101010501651601L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CO_EMPRESA")
	private Long id;
	
	@NotNull
	@Size(max=14)
	@Column(name = "CO_CNPJ")
	private String cnpj;
	
	@NotNull
	@Size(max=100)
	@Column(name = "NO_RAZAO_SOCIAL")
	private String razaoSocial;
	
	@NotNull
	@Size(max=100)
	@Column(name = "NO_NOME_FANTASIA")
	private String nomeFantasia;
	
	@NotNull
	@Column(name = "IC_SITUACAO")
	private Character situacao;
	
	@NotNull
	@Size(max=150)
	@Column(name = "NO_CLASSIFICACAO_TRIBUTARIA")
	private String classificacaoTributaria;
	
	@Size(max=150)
	@Column(name = "NO_NATUREZA_JURIDICA")
	private String naturezaJuridica;
	
	@NotNull
	@Column(name = "IC_REGISTRO_ELETRONICO_EMPREGADO")
	private Character registroEletronicoEmpregado;
	
	@NotNull
	@Column(name = "IC_COOPERATIVA")
	private Character cooperativa;
	
	@NotNull
	@Column(name = "IC_CONSTRUTORA")
	private Character construtora;
	
	@NotNull
	@Column(name = "IC_DESONERACAO_FOLHA")
	private Character desoneracaoFolha;
	
	@NotNull
	@Column(name = "IC_ENTIDADE_EDUCATIVA")
	private Character entidadeEducativa;
	
	@NotNull
	@Column(name = "IC_EMPRESA_TRABALHO_TEMPORARIO")
	private Character empresaTrabalhoTemporario;
	
	@NotNull
	@Column(name = "IC_SITUACAO_PESSOA_JURIDICA")
	private Character situacaoPessoaJuridica;
	
	@Column(name = "DT_ABERTURA")
	private LocalDate dataAbertura;
	
	@Size(max=10)
	@Column(name = "NO_TIPO_EMPRESA")
	private String tipoEmpresa;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENDERECO_CO")
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTATO_CO")
	private Contato contato;
}
