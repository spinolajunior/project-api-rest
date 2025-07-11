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
import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.services.RacerService;

@RestController
@RequestMapping(value = "/racers")
public class RacerResource {

	@Autowired
	RacerService service;

	@GetMapping
	public ResponseEntity<List<Racer>> findAll() {
		List<Racer> Racers = service.findAll();
		return ResponseEntity.ok().body(Racers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Racer> findById(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Racer> insert(@RequestBody Racer Racer) {
		return null;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Racer> update(@RequestBody Racer Racer) {
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		return null;
	}

}
