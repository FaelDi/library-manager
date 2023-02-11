package com.wordpress.faeldi.atividadeprogramacaowebii.service;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.CategoriaDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.CategoriaLivrosDTO;

public interface CategoriaService extends BaseService<CategoriaDTO>{

    public CategoriaLivrosDTO buscarLivrosPorCategoria(Long categoria_id);
}
