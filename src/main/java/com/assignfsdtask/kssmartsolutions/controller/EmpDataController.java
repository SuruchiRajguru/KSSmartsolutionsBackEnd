package com.assignfsdtask.kssmartsolutions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignfsdtask.kssmartsolutions.entity.EmpData;
import com.assignfsdtask.kssmartsolutions.model.ResponseDTO;
import com.assignfsdtask.kssmartsolutions.service.EmpDataService;


@RestController
@RequestMapping("/kssmartsolutions")
@CrossOrigin(origins="*")
public class EmpDataController {

	@Autowired
	private EmpDataService empDataService;
	
	@GetMapping("listEmpdata")
	public ResponseEntity<ResponseDTO> getEmployeeList()
	{
		return empDataService.getAllEmpData();
	}
	
	@PutMapping("updateEmpDataById")
	public ResponseEntity<ResponseDTO> updateEmpDataById(@RequestBody EmpData empData)
	{
		return empDataService.updateEmpDataById(empData);
	}
	
	
	
	@PostMapping("/saveEmpData")
	public ResponseEntity<ResponseDTO>  saveEmpData(@RequestBody EmpData empData)
	{
		return empDataService.saveEmpData(empData);
	}
	
	@DeleteMapping("/deleteEmpData/{id}")
	public ResponseEntity<ResponseDTO>  deleteEmpData(@PathVariable Integer id)
	{
		return empDataService.deleteEmpData(id);
	}
	
	@GetMapping("getEmployeeData/{id}")
	public ResponseEntity<ResponseDTO> getEmployeeList(@PathVariable Integer id)
	{
		return empDataService.getEmpData(id);
	}
	
}
