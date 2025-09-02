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

import com.robertojr.PROJECT_API_REST.entities.Reserve;
import com.robertojr.PROJECT_API_REST.resources.DTos.ReserveDTO;
import com.robertojr.PROJECT_API_REST.services.ReserveService;

@RestController
@RequestMapping(value = "/reserves")
public class ReserveResource {

	@Autowired
	ReserveService service;

	@GetMapping
	public ResponseEntity<List<ReserveDTO>> findAll() {
		List<Reserve> reserves = service.findAll();
		List<ReserveDTO> reservesDTO = new ArrayList<>();
		for (Reserve item : reserves) {
			reservesDTO.add(new ReserveDTO(item));
		}

		return ResponseEntity.ok().body(reservesDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ReserveDTO> findById(@PathVariable Long id) {
		Reserve obj = service.findById(id);
		ReserveDTO reserveDTO = new ReserveDTO(obj);
		return ResponseEntity.ok().body(reserveDTO);
	}

	@PostMapping
	public ResponseEntity<ReserveDTO> insert(@RequestBody Reserve Reserve) {

		Reserve = service.insert(Reserve);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Reserve.getId())
				.toUri();

		return ResponseEntity.created(uri).body(new ReserveDTO(Reserve));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Reserve> update(@PathVariable Long id, @RequestBody Reserve Reserve) {
		Reserve obj = service.update(id, Reserve);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
