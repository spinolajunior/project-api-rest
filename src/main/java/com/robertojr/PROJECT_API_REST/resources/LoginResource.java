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
import com.robertojr.PROJECT_API_REST.entities.Login;
import com.robertojr.PROJECT_API_REST.services.LoginService;

@RestController
@RequestMapping(value = "/logins")
public class LoginResource {

	@Autowired
	LoginService service;

	@GetMapping
	public ResponseEntity<List<Login>> findAll() {
		List<Login> Logins = service.findAll();
		return ResponseEntity.ok().body(Logins);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Login> findById(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Login> insert(@RequestBody Login Login) {
		return null;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Login> update(@RequestBody Login Login) {
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		return null;
	}

}
