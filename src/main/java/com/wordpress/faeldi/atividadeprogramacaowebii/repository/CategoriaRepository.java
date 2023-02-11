package com.wordpress.faeldi.atividadeprogramacaowebii.repository;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
