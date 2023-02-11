package com.wordpress.faeldi.atividadeprogramacaowebii.controller;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.CategoriaDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.service.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController extends BaseController<CategoriaDTO, CategoriaService> {
    public CategoriaController(CategoriaService service) {
        super(service);
    }
}
