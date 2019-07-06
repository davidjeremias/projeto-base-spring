package com.u2d.projeto.config;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.u2d.certificado.Certificado;
import br.com.u2d.certificado.exception.CertificadoException;
import br.com.u2d.nfe.dom.ConfiguracoesNfe;
import br.com.u2d.nfe.dom.enuns.AmbienteEnum;
import br.com.u2d.nfe.dom.enuns.EstadosEnum;

@Component
public class ConfiguracaoNFE {
	
	private static final String PATH_SCHEMA = "/opt/projetos/nfe/Schemas";
	
	@Autowired
	private CertificadoA1PFX certificadoA1PFX;
	
	public ConfiguracoesNfe iniciaNFE() throws FileNotFoundException, CertificadoException {
		Certificado certificado = certificadoA1PFX.certificadoA1();
		return ConfiguracoesNfe.criarConfiguracoes(EstadosEnum.DF, AmbienteEnum.HOMOLOGACAO, certificado, PATH_SCHEMA);
	}

}
