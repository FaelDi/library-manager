package com.wordpress.faeldi.atividadeprogramacaowebii.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EditoraLivrosDTO extends EditoraDTO{

    private List<LivroDTO> livros;
}
