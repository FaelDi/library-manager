package com.wordpress.faeldi.atividadeprogramacaowebii.controller;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.EditoraDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.service.EditoraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/editora")
public class EditoraController extends BaseController<EditoraDTO, EditoraService> {
    public EditoraController(EditoraService service) {
        super(service);
    }
}
