package com.wordpress.faeldi.atividadeprogramacaowebii.repository;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

}
