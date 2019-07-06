package com.u2d.projeto.service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.u2d.projeto.config.ConfiguracaoNFE;

import br.com.u2d.certificado.exception.CertificadoException;
import br.com.u2d.nfe.Nfe;
import br.com.u2d.nfe.dom.ConfiguracoesNfe;
import br.com.u2d.nfe.dom.enuns.DocumentoEnum;
import br.com.u2d.nfe.exception.NfeException;
import br.com.u2d.nfe.schema_4.retConsStatServ.TRetConsStatServ;

@Service
public class StatusSefazService {
	
	@Autowired
	private ConfiguracaoNFE configuracao;
	
	public TRetConsStatServ consultaStatus() throws FileNotFoundException, CertificadoException, NfeException {
		ConfiguracoesNfe config = configuracao.iniciaNFE();
		return Nfe.statusServico(config, DocumentoEnum.NFE);
	}

}
