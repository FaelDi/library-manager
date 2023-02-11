package com.wordpress.faeldi.atividadeprogramacaowebii.model.mapper;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.LivroDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Livro;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivroMapper {
    List<LivroDTO> parseListDTO(List<Livro> Livros);
    List<Livro> parseListEntity(List<LivroDTO> Livros);
    LivroDTO parseDTO(Livro Livro);
    Livro parseEntity(LivroDTO Livro);
}
