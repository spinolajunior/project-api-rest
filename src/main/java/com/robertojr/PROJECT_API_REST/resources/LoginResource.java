package com.robertojr.PROJECT_API_REST.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.robertojr.PROJECT_API_REST.entities.Driver;
import com.robertojr.PROJECT_API_REST.entities.Login;
import com.robertojr.PROJECT_API_REST.entities.User;
import com.robertojr.PROJECT_API_REST.resources.DTos.CustomerDTO;
import com.robertojr.PROJECT_API_REST.resources.DTos.DriverDTO;
import com.robertojr.PROJECT_API_REST.resources.DTos.LoginDTO;
import com.robertojr.PROJECT_API_REST.resources.DTos.UserDTO;
import com.robertojr.PROJECT_API_REST.services.CustomerService;
import com.robertojr.PROJECT_API_REST.services.DriverService;
import com.robertojr.PROJECT_API_REST.services.LoginService;
import com.robertojr.PROJECT_API_REST.services.UserService;
import com.robertojr.PROJECT_API_REST.services.exceptions.IlegalArgumentException;

@RestController
@RequestMapping(value = "/logins")
public class LoginResource {

	@Autowired
	LoginService service;
	@Autowired
	UserService userService;
	@Autowired
	CustomerService customerService;
	@Autowired
	DriverService driverService;

	@GetMapping
	public ResponseEntity<List<LoginDTO>> findAll() {
		List<Login> logins = service.findAll();
		List<LoginDTO> loginsDTO = new ArrayList<>();
		for (Login item : logins) {

			loginsDTO.add(new LoginDTO(item));
		}
		return ResponseEntity.ok().body(loginsDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<LoginDTO> findById(@PathVariable Long id) {
		Login obj = service.findById(id);
		LoginDTO loginDTO = new LoginDTO(obj);
		return ResponseEntity.ok().body(loginDTO);
	}

	@PostMapping
	public ResponseEntity<Login> insert(@RequestBody Login Login) {

		Login = service.insert(Login);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Login.getId()).toUri();

		return ResponseEntity.created(uri).body(Login);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Login> update(@PathVariable Long id, @RequestBody Login Login) {
		Login obj = service.update(id, Login);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/validate")
	public ResponseEntity<? extends UserDTO> validadeLogin(@RequestBody Login login) {

		List<LoginDTO> teste = findAll().getBody().stream()
				.filter(x -> x.getUsername().equals(login.getUserName()) && x.getPassword().equals(login.getPassword()))
				.toList();

		if (teste.size() > 0) {
			
			User user = userService.findById(teste.getFirst().getId());
			
			if (user instanceof Driver driver) {
				return ResponseEntity.ok().body(new DriverDTO(driver));
			} else if (user instanceof Customer customer) {
				return ResponseEntity.ok().body(new CustomerDTO(customer));
			}else {
				throw new IlegalArgumentException("User not Driver or Customer");
			}

		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

	}

	@PostMapping("/validate/new_login")
	public ResponseEntity<LoginDTO> validateNewLogin(@RequestBody Login login) {

		List<Login> logins = service.findAll();

		String email = logins.stream().filter(x -> x.getEmail().equals(login.getEmail())).findFirst()
				.map(Login::getEmail).orElse(null);
		String user = logins.stream().filter(x -> x.getUserName().equals(login.getUserName())).findFirst()
				.map(Login::getUserName).orElse(null);
		String password = logins.stream().filter(x -> x.getPassword().equals(login.getPassword())).findFirst()
				.map(Login::getPassword).orElse(null);

		LoginDTO validate = new LoginDTO();

		if (email == null) {
			validate.setEmail(login.getEmail());
		} else {
			validate.setEmail(null);
		}
		if (user == null) {
			validate.setUsername(login.getUserName());
		} else {
			validate.setUsername(null);
		}
		if (password == null) {
			validate.setPassword(login.getPassword());
		} else {
			validate.setPassword(null);
		}

		if (validate.getEmail() != null && validate.getUsername() != null && validate.getPassword() != null) {

			return ResponseEntity.ok().body(validate);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(validate);
		}

	}
}
