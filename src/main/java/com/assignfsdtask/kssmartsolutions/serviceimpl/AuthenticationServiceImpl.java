package com.assignfsdtask.kssmartsolutions.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.assignfsdtask.kssmartsolutions.model.AuthenticationRequest;
import com.assignfsdtask.kssmartsolutions.model.AuthenticationResponse;
import com.assignfsdtask.kssmartsolutions.model.ResponseDTO;
import com.assignfsdtask.kssmartsolutions.service.AuthenticationService;
import com.assignfsdtask.kssmartsolutions.utils.ConstantUtils;
import com.assignfsdtask.kssmartsolutions.utils.JwtUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDeatilsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Override
	public ResponseEntity<ResponseDTO> authenticateLogin(AuthenticationRequest authenticationRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
			}
			catch(BadCredentialsException e) {
				return new ResponseEntity<ResponseDTO>(new ResponseDTO(ConstantUtils.RESPONSE_FAIL,""),HttpStatus.OK);
				
			}
			 final UserDetails userDetails = userDeatilsService.loadUserByUsername(authenticationRequest.getUserName());
			 
			 final String jwt = jwtTokenUtil.generateToken(userDetails);
			 
			 return new ResponseEntity<ResponseDTO>(new ResponseDTO(ConstantUtils.RESPONSE_SUCCESS,new AuthenticationResponse(jwt)),HttpStatus.OK);	
	}

}
