package com.wordpress.faeldi.atividadeprogramacaowebii.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CategoriaLivrosDTO extends CategoriaDTO {

    private List<LivroDTO> livros;
}
