package com.wordpress.faeldi.atividadeprogramacaowebii.service;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.LivroDTO;

import java.util.List;

public interface LivroService extends BaseService<LivroDTO>{

    public List<LivroDTO> buscarPorNome(String nome);

    public List<LivroDTO> buscarPorIsbn(String nome);
}
