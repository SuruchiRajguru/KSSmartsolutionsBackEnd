package com.assignfsdtask.kssmartsolutions.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignfsdtask.kssmartsolutions.entity.EmpData;
import com.assignfsdtask.kssmartsolutions.model.ResponseDTO;
import com.assignfsdtask.kssmartsolutions.repository.EmpDataRepository;
import com.assignfsdtask.kssmartsolutions.service.EmpDataService;
import com.assignfsdtask.kssmartsolutions.utils.ConstantUtils;

@Service
public class EmpDataServiceImpl implements EmpDataService {
	
	@Autowired
	private EmpDataRepository empDataRepository;
	
	public ResponseEntity<ResponseDTO> generateResponse(String responseText, Object responseData,HttpStatus httpStatus) {
		return new ResponseEntity<>(new ResponseDTO(responseText, responseData), httpStatus);
	}
	
	@Override
	public ResponseEntity<ResponseDTO> getAllEmpData() {
		try
		{
			return generateResponse(ConstantUtils.RESPONSE_SUCCESS,getEmployeeDetailList(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return generateResponse(ConstantUtils.RESPONSE_FAIL,null, HttpStatus.OK);
		}
	}
	
	private List<EmpData> getEmployeeDetailList() {
		List<EmpData> empdata=empDataRepository.findAll();
		return empdata;
	}

	@Override
	public ResponseEntity<ResponseDTO> saveEmpData(EmpData empData) {
		try
		{
			empDataRepository.save(empData);
			return generateResponse(ConstantUtils.RESPONSE_SUCCESS,getEmployeeDetailList(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return generateResponse(ConstantUtils.RESPONSE_FAIL,null, HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteEmpData(Integer id) {
		try
		{
			if(id != null) {
				if(empDataRepository.existsById(id)) {
					empDataRepository.deleteById(id);
					return generateResponse(ConstantUtils.RESPONSE_SUCCESS,getEmployeeDetailList(), HttpStatus.OK);
				}else {
					return generateResponse(ConstantUtils.RESPONSE_NO_CONTENT,null, HttpStatus.OK);
				}
			}else {
				return generateResponse(ConstantUtils.RESPONSE_BAD_REQUEST,null, HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			return generateResponse(ConstantUtils.RESPONSE_FAIL,null, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}


	@Override
	public ResponseEntity<ResponseDTO> getEmpData(Integer id) {
		
		try
		{			
			if(id != null) {
				if(empDataRepository.existsById(id)) {
					return generateResponse(ConstantUtils.RESPONSE_SUCCESS,empDataRepository.findById(id).get(), HttpStatus.OK);
				}else {
					return generateResponse(ConstantUtils.RESPONSE_NO_CONTENT,null, HttpStatus.OK);
				}
			}else {
				return generateResponse(ConstantUtils.RESPONSE_BAD_REQUEST,null, HttpStatus.OK);
			}
			
		}
		catch(Exception e)
		{
			return generateResponse(ConstantUtils.RESPONSE_FAIL,null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> updateEmpDataById(EmpData empDataToUpdate) {
		try {
			if(empDataToUpdate.getId() != null) {
				Optional<EmpData> empInfoOptional = empDataRepository.findById(empDataToUpdate.getId());
				if(empInfoOptional.isPresent()) {
					EmpData empInfo = empInfoOptional.get();
					empInfo.setCity(empDataToUpdate.getCity());
					empInfo.setDesignation(empDataToUpdate.getDesignation());
					empInfo.setGender(empDataToUpdate.getGender());
					empInfo.setName(empDataToUpdate.getName());
					empDataRepository.save(empInfo);
					return generateResponse(ConstantUtils.RESPONSE_SUCCESS,getEmployeeDetailList(), HttpStatus.OK);
				}else {
					return generateResponse(ConstantUtils.RESPONSE_NO_CONTENT,getEmployeeDetailList(), HttpStatus.OK);
				}
			}else {
				return generateResponse(ConstantUtils.RESPONSE_BAD_REQUEST,getEmployeeDetailList(), HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			return generateResponse(ConstantUtils.RESPONSE_FAIL,null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
