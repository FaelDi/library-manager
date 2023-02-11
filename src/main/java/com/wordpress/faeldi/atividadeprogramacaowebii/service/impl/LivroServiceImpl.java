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
        Optional<Livro> LivroOp = repository.findById(id);
        if(LivroOp.isPresent()) {
            Livro Livro = LivroOp.get();
            return mapper.parseDTO(Livro);
        }

        throw new EntityNotFoundException();
    }

    @Override
    public LivroDTO criar(LivroDTO LivroDTO) {
        Livro Livro = mapper.parseEntity(LivroDTO);

        Livro.setNome(LivroDTO.getNome());

        Livro.setId(null);
        repository.save(Livro);
        return mapper.parseDTO(Livro);
    }

    @Override
    public LivroDTO editar(Long id, LivroDTO LivroDTO) {
        if(repository.existsById(id)) {
            Livro Livro = mapper.parseEntity(LivroDTO);
            Livro.setId(id);
            Livro = repository.save(Livro);
            return mapper.parseDTO(Livro);
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
