package com.robertojr.PROJECT_API_REST.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.services.DriverService;

@RestController
@RequestMapping(value = "/drivers")
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
		Driver obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Driver> insert(@RequestBody Driver Driver) {
		
		Driver = service.insert(Driver);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(Driver.getId()).toUri();
		
		return ResponseEntity.created(uri).body(Driver);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Driver> update(@PathVariable Long id,@RequestBody Driver Driver) {
		Driver obj = service.update(id, Driver);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
