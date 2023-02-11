package com.wordpress.faeldi.atividadeprogramacaowebii.controller;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.CategoriaLivrosDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.EditoraDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.service.EditoraService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/editora")
@Slf4j
public class EditoraController extends BaseController<EditoraDTO, EditoraService> {
    public EditoraController(EditoraService service) {
        super(service);
    }

    @GetMapping("/{editora}/livros")
    public ResponseEntity<CategoriaLivrosDTO> buscarLivrosPorCategoria(@PathVariable("editora") Long categoria) {
        try {

            return ResponseEntity.ok(service.buscarLivrosPorEditora(categoria));

        }catch(EntityNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception ex) {

            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
