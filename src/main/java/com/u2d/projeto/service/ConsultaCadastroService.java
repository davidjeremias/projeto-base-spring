package com.u2d.projeto.service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.u2d.projeto.config.ConfiguracaoNFE;

import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.dom.enuns.PessoaEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import br.com.swconsultoria.nfe.schema.retConsCad.TRetConsCad;

@Service
public class ConsultaCadastroService {

	@Autowired
	private ConfiguracaoNFE configuracao;
	
	public TRetConsCad consultaCadastro(String cnpj) throws FileNotFoundException, CertificadoException, NfeException {
		ConfiguracoesNfe config = configuracao.iniciaNFE();
		return Nfe.consultaCadastro(config, PessoaEnum.JURIDICA, cnpj, EstadosEnum.GO);
	}
}
