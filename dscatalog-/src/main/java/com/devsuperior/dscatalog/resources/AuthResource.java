package com.devsuperior.dscatalog.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dscatalog.dto.EmailDTO;
import com.devsuperior.dscatalog.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {


	@Autowired
	private AuthService service;

	@PostMapping(value = "/recover-token")
	public ResponseEntity<Void> CreateRecoverToken(@Valid @RequestBody EmailDTO body) {
		service.CreateRecoverToken(body);
		return ResponseEntity.noContent().build();
	}


} 
