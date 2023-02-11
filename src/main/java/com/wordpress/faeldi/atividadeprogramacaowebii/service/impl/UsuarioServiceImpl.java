package com.wordpress.faeldi.atividadeprogramacaowebii.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.TokenDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.UsuarioDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.UsuarioLoginDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Usuario;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.mapper.UsuarioMapper;
import com.wordpress.faeldi.atividadeprogramacaowebii.repository.UsuarioRepository;
import com.wordpress.faeldi.atividadeprogramacaowebii.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Value("${api.viacep}")
	private String urlViaCep;
	
	public List<UsuarioLoginDTO> buscarTodos() {
		return mapper.parseListDTO(repository.findAll());
	}
	
	public UsuarioLoginDTO buscarUm(Long id) {
		Optional<Usuario> usuarioOp = repository.findById(id);
		if(usuarioOp.isPresent()) {
			Usuario usuario = usuarioOp.get();
			return mapper.parseDTO(usuario);
		}
		
		throw new EntityNotFoundException();
	}
	
	public UsuarioLoginDTO criar(UsuarioLoginDTO clienteDTO) {
		Usuario usuario = mapper.parseEntity(clienteDTO);
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		usuario.setId(null);
		repository.save(usuario);
		return mapper.parseDTO(usuario);
	}
	
	public UsuarioLoginDTO editar(Long id, UsuarioLoginDTO usuarioDTO) {
		
		Optional<Usuario> usuarioOp = repository.findById(id);
		
		if(usuarioOp.isPresent()) {
			Usuario usuario = usuarioOp.get();
			usuario.setNome(usuarioDTO.getNome());
			usuario.setEmail(usuarioDTO.getEmail());
			usuario.setId(id);
			usuario = repository.save(usuario);
			return mapper.parseDTO(usuario);
		}
		
		throw new EntityNotFoundException();
	}
	
	public void excluir(Long id) {
		if(!repository.existsById(id)) {
			throw new EntityNotFoundException();
		}
		
		repository.deleteById(id);
	}
	
	public TokenDTO logar(UsuarioLoginDTO usuarioLoginDTO) throws AuthenticationException,EntityNotFoundException {
		
		UsernamePasswordAuthenticationToken autentication = 
				new UsernamePasswordAuthenticationToken(usuarioLoginDTO.getUsername(),usuarioLoginDTO.getPassword());
		
		authenticationManager.authenticate(autentication);
		
		Optional<Usuario> usuarioOp = repository.findByUsername(usuarioLoginDTO.getUsername());
		
		if(usuarioOp.isPresent()) {
		
			String token = jwtService.generateToken(usuarioLoginDTO.getUsername());
			
			Usuario usuario = usuarioOp.get();
			
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuario.setNome(usuario.getNome());
			usuario.setEmail(usuario.getEmail());	
			
			return TokenDTO.builder()
					.token(token)
					.type("Bearer")
					.user(usuarioDTO)
					.build();
		}
		
		throw new EntityNotFoundException();
	}
}
