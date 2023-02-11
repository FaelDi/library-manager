package com.wordpress.faeldi.atividadeprogramacaowebii.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class JWTService {
	
	private static SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public String generateToken(String username) {
		
		LocalDateTime dataAtual = LocalDateTime.now();
		LocalDateTime dataExpiracao = dataAtual.plusMinutes(30l);
		
		return Jwts.builder()
			.setIssuedAt(new Date(dataAtual.toInstant(ZoneOffset.UTC).toEpochMilli()))
			.setExpiration(new Date(dataExpiracao.toInstant(ZoneOffset.UTC).toEpochMilli()))
			.setSubject(username)
			.signWith(secretKey)
			.compact();
			
	}
}
