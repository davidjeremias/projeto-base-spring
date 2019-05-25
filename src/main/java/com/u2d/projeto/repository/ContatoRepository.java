package com.u2d.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.u2d.projeto.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
}
