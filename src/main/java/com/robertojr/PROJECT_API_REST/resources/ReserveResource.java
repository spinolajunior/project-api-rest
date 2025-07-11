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
import com.robertojr.PROJECT_API_REST.entities.Reserve;
import com.robertojr.PROJECT_API_REST.services.ReserveService;

@RestController
@RequestMapping(value = "/reserves")
public class ReserveResource {

	@Autowired
	ReserveService service;

	@GetMapping
	public ResponseEntity<List<Reserve>> findAll() {
		List<Reserve> Reserves = service.findAll();
		return ResponseEntity.ok().body(Reserves);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Reserve> findById(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Reserve> insert(@RequestBody Reserve Reserve) {
		return null;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Reserve> update(@RequestBody Reserve Reserve) {
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		return null;
	}

}
