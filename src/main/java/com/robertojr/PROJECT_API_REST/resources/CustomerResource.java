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
import com.robertojr.PROJECT_API_REST.entities.Customer;
import com.robertojr.PROJECT_API_REST.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	@Autowired
	CustomerService service;

	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> Customers = service.findAll();
		return ResponseEntity.ok().body(Customers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Customer> insert(@RequestBody Customer Customer) {
		return null;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Customer> update(@RequestBody Customer Customer) {
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		return null;
	}

}
