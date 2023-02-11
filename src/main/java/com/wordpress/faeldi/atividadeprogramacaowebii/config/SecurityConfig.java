package com.wordpress.faeldi.atividadeprogramacaowebii.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
        		.csrf().disable()
        		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        		.and()
        		.authorizeHttpRequests()
        		.requestMatchers(HttpMethod.POST, "/**").permitAll()
				.requestMatchers(HttpMethod.GET, "/**").permitAll()
        		.requestMatchers(PathRequest.toH2Console()).permitAll()
        		.anyRequest().authenticated()
        		.and()
        		.headers().frameOptions().disable()
        		.and()
        		.build();
    }
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();	
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authConfig) {
		try {
			return authConfig.getAuthenticationManager();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
