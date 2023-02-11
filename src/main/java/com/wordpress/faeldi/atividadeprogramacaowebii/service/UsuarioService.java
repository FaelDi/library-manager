package com.wordpress.faeldi.atividadeprogramacaowebii.service;

import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.TokenDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.UsuarioLoginDTO;

public interface UsuarioService extends BaseService<UsuarioLoginDTO>{
	TokenDTO logar(UsuarioLoginDTO usuarioDTO);
}
