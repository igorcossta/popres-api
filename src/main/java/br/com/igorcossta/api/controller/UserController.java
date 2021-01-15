package br.com.igorcossta.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igorcossta.api.dto.model.UserDto;
import br.com.igorcossta.domain.model.User;
import br.com.igorcossta.domain.service.UserService;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDto>> returnAll() {

		List<User> users = service.findAll();

		if (users.isEmpty()) {
			ResponseEntity.noContent().build();
		}

		List<UserDto> dto = users.stream().map(user -> new UserDto(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<UserDto> returnUser(@PathVariable(name = "id") long id) {

		User obj = service.findById(id);
		UserDto dto = new UserDto(obj);

		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<UserDto> insertUser(@RequestBody @Valid UserDto dto) {

		User obj = service.insert(dto.transformaParaObjeto());
		UserDto res = new UserDto(obj);

		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id) {

		service.delete(id);

		return ResponseEntity.noContent().build();
	}

}
