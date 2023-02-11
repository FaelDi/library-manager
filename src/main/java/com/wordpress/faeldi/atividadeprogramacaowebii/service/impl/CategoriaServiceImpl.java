package com.wordpress.faeldi.atividadeprogramacaowebii.service.impl;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.CategoriaDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Categoria;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.mapper.CategoriaMapper;
import com.wordpress.faeldi.atividadeprogramacaowebii.repository.CategoriaRepository;
import com.wordpress.faeldi.atividadeprogramacaowebii.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaMapper mapper;
    
    @Override
    public List<CategoriaDTO> buscarTodos() {
        return mapper.parseListDTO(repository.findAll());
    }

    @Override
    public CategoriaDTO buscarUm(Long id) {
        Optional<Categoria> categoriaOp = repository.findById(id);
        if(categoriaOp.isPresent()) {
            Categoria categoria = categoriaOp.get();
            return mapper.parseDTO(categoria);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public CategoriaDTO criar(CategoriaDTO categoriaDTO) {
        Categoria categoria = mapper.parseEntity(categoriaDTO);

        categoria.setNome(categoriaDTO.getNome());

        categoria.setId(null);
        repository.save(categoria);
        return mapper.parseDTO(categoria);
    }

    @Override
    public CategoriaDTO editar(Long id, CategoriaDTO categoriaDTO) {
        if(repository.existsById(id)) {
            Categoria categoria = mapper.parseEntity(categoriaDTO);
            categoria.setId(id);
            categoria = repository.save(categoria);
            return mapper.parseDTO(categoria);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public void excluir(Long id) {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException();
        }

        repository.deleteById(id);
    }
}
