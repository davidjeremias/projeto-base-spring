package com.u2d.projeto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.u2d.projeto.model.Empresa;
import com.u2d.projeto.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
public class EmpresaResource {
	
	@Autowired
	private EmpresaService service;
	
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
	
	@PostMapping
	public ResponseEntity<Empresa> save(@RequestBody Empresa empresa){
		Empresa empresaSalva = service.save(empresa);
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
