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

import com.robertojr.PROJECT_API_REST.entities.Racer;
import com.robertojr.PROJECT_API_REST.resources.DTos.RacerDTO;
import com.robertojr.PROJECT_API_REST.services.RacerService;

@RestController
@RequestMapping(value = "/racers")
public class RacerResource {

	@Autowired
	RacerService service;

	@GetMapping
	public ResponseEntity<List<RacerDTO>> findAll() {
		List<Racer> racers = service.findAll();
		List<RacerDTO> racersDTO = new ArrayList<>();
		for (Racer item : racers) {
			racersDTO.add(new RacerDTO(item));
		}
		return ResponseEntity.ok().body(racersDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<RacerDTO> findById(@PathVariable Long id) {
		Racer obj = service.findById(id);
		RacerDTO racerDTO = new RacerDTO(obj);
		return ResponseEntity.ok().body(racerDTO);
	}

	@PostMapping
	public ResponseEntity<Racer> insert(@RequestBody Racer Racer) {

		Racer = service.insert(Racer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Racer.getId()).toUri();

		return ResponseEntity.created(uri).body(Racer);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Racer> update(@PathVariable Long id, @RequestBody Racer Racer) {
		Racer obj = service.update(id, Racer);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
