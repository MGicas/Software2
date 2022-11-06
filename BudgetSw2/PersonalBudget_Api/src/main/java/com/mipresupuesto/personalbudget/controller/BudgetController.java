package com.mipresupuesto.personalbudget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mipresupuesto.personalbudget.application.command.interfaces.CreateBudgetPort;
import com.mipresupuesto.personalbudget.controller.response.Response;
import com.mipresupuesto.personalbudget.controller.response.dto.Message;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;

@RestController
@RequestMapping("api/v1/budget")
public class BudgetController {
	
	Logger log = LoggerFactory.getLogger(BudgetController.class);
	
	@Autowired
	private CreateBudgetPort createBudgetPort;

	@PostMapping
	public ResponseEntity<Response<BudgetDTO>> create(@RequestBody BudgetDTO budget) {
		
		createBudgetPort.execute(budget);
		final Response<BudgetDTO> response = new Response<>();
		HttpStatus statusCode = HttpStatus.OK;
		
		try {
			response.addMessage(Message.createSuccessMessage("El budget se creo de forma satisfactoria"));
			log.info("El budget se creo de forma satisfactoria", response);
			
		}catch (final Exception exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.addMessage(Message.createErrorMessage("Ha ocurrido un problema inesperado tratando de crear el presupesto deseado..."));
			log.error("Ha ocurrido un problema inesperado tratando de crear el presupesto deseado...", exception);
		}
		
		return new ResponseEntity<>(response, statusCode);
	}

	@GetMapping
	public ResponseEntity<Response<BudgetDTO>> saludar() {
		
		final Response<BudgetDTO> response = new Response<>();
		HttpStatus statusCode = HttpStatus.OK;
		
		try {
			response.addMessage(Message.createInformationMessage("El budget se consulto de forma satisfactoria"));
			log.info("El budget se consulto de forma satisfactoria", response);
			
		}catch (final Exception exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.addMessage(Message.createWarningMessage("Ha ocurrido un problema inesperado tratando de consultar el presupesto deseado..."));
			log.error("Ha ocurrido un problema inesperado tratando de consultar el presupesto deseado...", exception);
		}
		
		return new ResponseEntity<>(response, statusCode);
	}
	
}
