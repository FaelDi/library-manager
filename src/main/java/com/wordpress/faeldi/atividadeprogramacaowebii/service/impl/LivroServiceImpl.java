package com.wordpress.faeldi.atividadeprogramacaowebii.service.impl;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.LivroDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Livro;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.mapper.LivroMapper;
import com.wordpress.faeldi.atividadeprogramacaowebii.repository.LivroRepository;
import com.wordpress.faeldi.atividadeprogramacaowebii.service.LivroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private LivroMapper mapper;

    @Override
    public List<LivroDTO> buscarTodos() {
        return mapper.parseListDTO(repository.findAll());
    }

    @Override
    public LivroDTO buscarUm(Long id) {
        Optional<Livro> livroOp = repository.findById(id);
        if(livroOp.isPresent()) {
            Livro livro = livroOp.get();
            return mapper.parseDTO(livro);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public LivroDTO criar(LivroDTO LivroDTO) {
        Livro livro = mapper.parseEntity(LivroDTO);

        livro.setNome(LivroDTO.getNome());

        livro.setId(null);
        repository.save(livro);
        return mapper.parseDTO(livro);
    }

    @Override
    public LivroDTO editar(Long id, LivroDTO LivroDTO) {
        if(repository.existsById(id)) {
            Livro livro = mapper.parseEntity(LivroDTO);
            livro.setId(id);
            livro = repository.save(livro);
            return mapper.parseDTO(livro);
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
