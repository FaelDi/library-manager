package com.wordpress.faeldi.atividadeprogramacaowebii.model.mapper;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.EditoraDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Editora;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditoraMapper 
{
    List<EditoraDTO> parseListDTO(List<Editora> Editoras);
    List<Editora> parseListEntity(List<EditoraDTO> Editoras);
    EditoraDTO parseDTO(Editora Editora);
    Editora parseEntity(EditoraDTO Editora);
}
