package com.u2d.projeto.resource;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.u2d.projeto.service.ConsultaCadastroService;
import com.u2d.projeto.service.StatusSefazService;

import br.com.u2d.certificado.exception.CertificadoException;
import br.com.u2d.nfe.exception.NfeException;
import br.com.u2d.nfe.schema.retConsCad.TRetConsCad;
import br.com.u2d.nfe.schema_4.retConsStatServ.TRetConsStatServ;

@RestController
@RequestMapping("/consultaSefaz")
@CrossOrigin("*")
public class ConsultaSefazResource {
	
	@Autowired
	private ConsultaCadastroService consultaCadastroService;
	
	@Autowired
	private StatusSefazService statusSefazService;
	
	@GetMapping("/{cnpj}/cadastro")
	public ResponseEntity<TRetConsCad> consultaCadastro(@PathVariable String cnpj) throws FileNotFoundException, CertificadoException, NfeException{
		TRetConsCad retorno = consultaCadastroService.consultaCadastro(cnpj);
		return retorno != null ? ResponseEntity.status(HttpStatus.OK).body(retorno)
				: ResponseEntity.noContent().build();
	}
	
	@GetMapping("/status")
	public ResponseEntity<TRetConsStatServ> buscaStatusSefaz() throws FileNotFoundException, CertificadoException, NfeException{
		TRetConsStatServ retorno = statusSefazService.consultaStatus();
		return retorno != null ? ResponseEntity.status(HttpStatus.OK).body(retorno)
				: ResponseEntity.noContent().build();
	}

}
