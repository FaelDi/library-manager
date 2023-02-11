package com.wordpress.faeldi.atividadeprogramacaowebii.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocalidadeDTO {
	private String cep;
	private String uf;
	private String localidade;
	private String bairro;
	private String logradouro;
	private String complemento;
}
