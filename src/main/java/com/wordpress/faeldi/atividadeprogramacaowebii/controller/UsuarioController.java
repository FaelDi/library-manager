package com.wordpress.faeldi.atividadeprogramacaowebii.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.TokenDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.UsuarioLoginDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UsuarioController extends BaseController<UsuarioLoginDTO, UsuarioService>  {
	
	public UsuarioController(UsuarioService service) {
		super(service);
	}
	
	@PostMapping("/auth")
	public ResponseEntity<TokenDTO> logar(@RequestBody @Valid UsuarioLoginDTO entidade) {
		try {

            return ResponseEntity.ok(service.logar(entidade));

        }catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
	}
}
