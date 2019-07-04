package com.u2d.projeto.config;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;

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
