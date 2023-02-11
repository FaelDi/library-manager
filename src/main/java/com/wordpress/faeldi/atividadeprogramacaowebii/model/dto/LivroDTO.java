package com.wordpress.faeldi.atividadeprogramacaowebii.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivroDTO {

    private Long id;
    private String nome;
    private String isbn;
}
