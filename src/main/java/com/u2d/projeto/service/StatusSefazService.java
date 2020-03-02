package com.u2d.projeto.service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.u2d.projeto.config.ConfiguracaoNFE;

import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import br.com.swconsultoria.nfe.schema_4.retConsStatServ.TRetConsStatServ;

@Service
public class StatusSefazService {
	
	@Autowired
	private ConfiguracaoNFE configuracao;
	
	public TRetConsStatServ consultaStatus() throws FileNotFoundException, CertificadoException, NfeException {
		ConfiguracoesNfe config = configuracao.iniciaNFE();
		return Nfe.statusServico(config, DocumentoEnum.NFE);
	}

}
