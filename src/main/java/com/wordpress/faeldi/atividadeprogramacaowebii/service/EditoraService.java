package com.wordpress.faeldi.atividadeprogramacaowebii.service;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.CategoriaLivrosDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.EditoraDTO;
public interface EditoraService extends BaseService<EditoraDTO> {

    public CategoriaLivrosDTO buscarLivrosPorEditora(Long editora_id);
}
