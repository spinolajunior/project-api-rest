package com.robertojr.PROJECT_API_REST.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.services.DriverService;

@RestController
@RequestMapping(value = "/Drivers")
public class DriverResource {

	@Autowired
	DriverService service;

	@GetMapping
	public ResponseEntity<List<Driver>> findAll() {
		List<Driver> Drivers = service.findAll();
		return ResponseEntity.ok().body(Drivers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Driver> findById(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Driver> insert(@RequestBody Driver Driver) {
		return null;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Driver> update(@RequestBody Driver Driver) {
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		return null;
	}

}
