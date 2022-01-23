package com.assignfsdtask.kssmartsolutions.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.assignfsdtask.kssmartsolutions.entity.EmpData;
import com.assignfsdtask.kssmartsolutions.model.ResponseDTO;

public interface EmpDataService {
	
	public ResponseEntity<ResponseDTO> getAllEmpData();
	
	public ResponseEntity<ResponseDTO> getEmpData(Integer id);
	
	public ResponseEntity<ResponseDTO> saveEmpData(EmpData empData);
	
	public ResponseEntity<ResponseDTO> updateEmpDataById(EmpData empData); 
	
	public ResponseEntity<ResponseDTO> deleteEmpData(Integer id); 

}
