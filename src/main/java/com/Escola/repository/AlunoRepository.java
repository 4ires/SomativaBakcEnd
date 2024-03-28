package com.Escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Escola.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
