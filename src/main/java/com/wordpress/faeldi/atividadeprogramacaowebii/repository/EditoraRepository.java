package com.wordpress.faeldi.atividadeprogramacaowebii.repository;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora,Long> {
}
