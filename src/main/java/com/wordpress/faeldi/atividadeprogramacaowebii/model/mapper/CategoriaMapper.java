package com.wordpress.faeldi.atividadeprogramacaowebii.model.mapper;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.CategoriaDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    List<CategoriaDTO> parseListDTO(List<Categoria> Categorias);
    List<Categoria> parseListEntity(List<CategoriaDTO> Categorias);
    CategoriaDTO parseDTO(Categoria Categoria);
    Categoria parseEntity(CategoriaDTO Categoria);
}
