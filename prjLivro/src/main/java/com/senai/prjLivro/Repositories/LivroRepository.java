package com.senai.prjLivro.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.prjLivro.Entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}