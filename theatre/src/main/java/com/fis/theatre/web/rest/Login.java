package com.fis.theatre.web.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.model.User;
import com.fis.theatre.utils.TokenUtils;
import com.fis.theatre.web.dto.LoginDTO;
import com.fis.theatre.web.dto.TokenResponseDTO;

@RestController
@CrossOrigin
public class Login {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	TokenUtils tokenUtils;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {
		System.out.println("ygwadfshxjk");
		System.out.println(loginDTO.getPassword());
		System.out.println(loginDTO.getUsername());
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
		System.out.println(auth.getName());
		SecurityContextHolder.getContext().setAuthentication(auth);

		User user = (User) auth.getPrincipal();
		System.out.println(user.getEmail());
		String jwt = tokenUtils.generateToken(user.getUsername());
		return ResponseEntity.ok(new TokenResponseDTO(jwt));
	}
}
