package com.assignfsdtask.kssmartsolutions.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ResponseDTO implements Serializable {

	private static long serialVersionUID = 1L;
	private String responseText;
	private Object responseData;

}
