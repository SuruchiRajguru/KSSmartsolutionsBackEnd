package com.assignfsdtask.kssmartsolutions.service;

import org.springframework.http.ResponseEntity;

import com.assignfsdtask.kssmartsolutions.model.AuthenticationRequest;
import com.assignfsdtask.kssmartsolutions.model.ResponseDTO;

public interface AuthenticationService {
	
	public ResponseEntity<ResponseDTO> authenticateLogin(AuthenticationRequest authenticationRequest);

}
