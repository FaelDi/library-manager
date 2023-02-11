package com.wordpress.faeldi.atividadeprogramacaowebii.controller;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.LivroDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.service.LivroService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController extends BaseController<LivroDTO, LivroService> {
    public LivroController(LivroService service) {
        super(service);
    }
}
