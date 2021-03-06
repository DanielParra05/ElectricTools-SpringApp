package com.spring.electric.tools.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.electric.tools.models.entities.Ajustes;
import com.spring.electric.tools.models.services.AjustesServiceImpl;

//Autorizacion para que angular pueda conectarse con el back
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AjustesRestController {

	@Autowired
	private AjustesServiceImpl ajusteService;
	
	@GetMapping("/ajustes")
	public Ajustes getAjuste() {
		return ajusteService.getAjuste();
	}
	
	
	@PostMapping("/ajustes")
	public ResponseEntity<?> create(@RequestBody Ajustes ajuste) {
		Ajustes ajusteNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			ajusteNew = ajusteService.save(ajuste);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Ajustes guardados exitosamente");
		response.put("ajustes", ajusteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
