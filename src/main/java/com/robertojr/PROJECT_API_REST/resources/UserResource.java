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

import com.robertojr.PROJECT_API_REST.entities.User;
import com.robertojr.PROJECT_API_REST.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = service.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		return null;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@RequestBody User user) {
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		return null;
	}

}
