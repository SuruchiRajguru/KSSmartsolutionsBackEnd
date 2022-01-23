package com.assignfsdtask.kssmartsolutions.controller;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignfsdtask.kssmartsolutions.entity.EmpData;
import com.assignfsdtask.kssmartsolutions.model.AuthenticationRequest;
import com.assignfsdtask.kssmartsolutions.model.AuthenticationResponse;
import com.assignfsdtask.kssmartsolutions.service.AuthenticationService;
import com.assignfsdtask.kssmartsolutions.serviceimpl.MyUserDetailsService;
import com.assignfsdtask.kssmartsolutions.utils.JwtUtil;

@RestController
@RequestMapping("/kssmartsolutions/authentication")
@CrossOrigin(origins="*")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createJwtToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
			 return authenticationService.authenticateLogin(authenticationRequest);
	}

}
