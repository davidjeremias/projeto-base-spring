package com.u2d.projeto.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.u2d.projeto.auditoria.AuditoriaInterface;
import com.u2d.projeto.auditoria.TipoEventoAuditoriaEnum;
import com.u2d.projeto.event.RecursoCriadoEvent;
import com.u2d.projeto.model.Empresa;
import com.u2d.projeto.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	
	@Autowired
	private ApplicationEventPublisher publishe;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Empresa> empresasSalvas = service.findAll();
		return !empresasSalvas.isEmpty() ? ResponseEntity.ok(empresasSalvas) 
				: ResponseEntity.noContent().build(); 
	}
	
	@GetMapping("/{codigo}/findById")
	public ResponseEntity<Empresa> findById(@PathVariable Long codigo){
		Empresa empresaSalva = service.findById(codigo);
		return empresaSalva != null ? ResponseEntity.status(HttpStatus.OK).body(empresaSalva)
				: ResponseEntity.noContent().build();
	}
	
	@AuditoriaInterface(funcionalidade="Cadastro Empresa", evento=TipoEventoAuditoriaEnum.INSERCAO)
	@PostMapping
	public ResponseEntity<Empresa> save(@Valid @RequestBody Empresa empresa, HttpServletResponse response){
		Empresa empresaSalva = service.save(empresa);
		publishe.publishEvent(new RecursoCriadoEvent(this, response, empresaSalva.getId()));
		return empresaSalva != null ? ResponseEntity.status(HttpStatus.CREATED).body(empresaSalva)
				: ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{codigo}/update")
	public ResponseEntity<Empresa> update(@PathVariable Long codigo, @RequestBody Empresa empresa){
		Empresa empresaSalva = service.update(codigo, empresa);
		return empresaSalva != null ? ResponseEntity.status(HttpStatus.OK).body(empresaSalva)
				: ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{codigo}/delete")
	public void delete(@PathVariable Long codigo){
		service.delete(codigo);
	}

}
