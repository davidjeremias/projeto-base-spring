package com.u2d.projeto.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.u2d.projeto.auditoria.TipoEventoAuditoriaEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "TB004_AUDITORIA")
public class Auditoria implements Serializable{

	private static final long serialVersionUID = -8050294797646306364L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CO_AUDITORIA")
	private Long id;
	
	@Column(name = "NO_FUNCIONALIDADE")
	private String funcionalidade;
	
	@Column(name = "NO_EVENTO")
	private TipoEventoAuditoriaEnum evento;
	
	@Column(name = "DT_DATA_HORA")
	private LocalDateTime dataHora;
	
	@Column(name = "NO_USUARIO")
	private String usuario;
	
	@Column(name = "NU_HOSTNAME")
	private String hostname;
	
	@Tolerate
	public Auditoria() {}

}
