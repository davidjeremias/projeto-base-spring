package com.u2d.projeto.config;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;

import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.exception.CertificadoException;

@Component
public class CertificadoA1PFX {
	
	private static final String PATH_CERTIFICADO = "/opt/projetos/nfe/cert.pfx";
	private static final String SENHA = "1234";
	
	public Certificado certificadoA1() throws CertificadoException, FileNotFoundException {
		return CertificadoService.certificadoPfx(PATH_CERTIFICADO, SENHA);
	}

}
