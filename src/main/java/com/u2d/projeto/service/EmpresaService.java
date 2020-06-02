package com.u2d.projeto.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.u2d.projeto.model.Empresa;
import com.u2d.projeto.repository.EmpresaRepository;
import com.u2d.projeto.util.ZipArchive;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;

	public List<Empresa> findAll() {
		return repository.findAll();
	}

	public Empresa save(Empresa empresa) {
		return repository.save(empresa);
	}

	public Empresa findById(Long codigo) {
		Optional<Empresa> empresa = repository.findById(codigo);
		if(empresa.isPresent())
			return empresa.get();
		return null;
	}

	public Empresa update(Long codigo, Empresa empresa) {
		Empresa empresaSalva = findById(codigo);
		if(empresaSalva.getId() != null)
			return repository.save(empresa);
		return null;
	}

	public void delete(Long codigo) {
		Empresa empresaSalva = findById(codigo);
		if(empresaSalva != null)
			repository.delete(empresaSalva);
	}
}
