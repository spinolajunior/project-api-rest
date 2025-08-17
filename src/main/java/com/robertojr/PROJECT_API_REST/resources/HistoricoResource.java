package com.robertojr.PROJECT_API_REST.resources;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robertojr.PROJECT_API_REST.entities.Historico;
import com.robertojr.PROJECT_API_REST.services.HistoricoService;

@RestController
@RequestMapping(value =  "/historicos")
public class HistoricoResource {
	
	@Autowired
	HistoricoService service;
	
	@GetMapping(value = "/driver/{id}")
	public ResponseEntity<Set<Historico>> findByDriver(@PathVariable Long id){

			Set<Historico> set = service.findByDriver(id);
			return ResponseEntity.ok().body(set);
					
	}
	
	@GetMapping(value = "/customer/{id}")
	public ResponseEntity<Set<Historico>> findByCustomer(@PathVariable Long id){

			Set<Historico> set = service.findByCustomer(id);
			return ResponseEntity.ok().body(set);
					
	}

}
