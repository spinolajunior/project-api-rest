package com.robertojr.PROJECT_API_REST.resources;

import java.net.URI;
import java.util.ArrayList;
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

import com.robertojr.PROJECT_API_REST.entities.Customer;
import com.robertojr.PROJECT_API_REST.resources.DTos.CustomerDTO;
import com.robertojr.PROJECT_API_REST.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	@Autowired
	CustomerService service;

	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findAll() {
		List<Customer> customers = service.findAll();
		List<CustomerDTO> customerDTO = new ArrayList<>();
		for (Customer item : customers) {
			customerDTO.add(new CustomerDTO(item));
		}
		return ResponseEntity.ok().body(customerDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
		Customer obj = service.findById(id);
		CustomerDTO customerDTO = new CustomerDTO(obj);
		return ResponseEntity.ok().body(customerDTO);
	}

	@PostMapping
	public ResponseEntity<Customer> insert(@RequestBody Customer Customer) {

		Customer = service.insert(Customer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Customer.getId())
				.toUri();

		return ResponseEntity.created(uri).body(Customer);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer Customer) {
		Customer obj = service.update(id, Customer);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
