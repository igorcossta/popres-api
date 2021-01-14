package br.com.igorcossta.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igorcossta.domain.exception.UserNotFound;
import br.com.igorcossta.domain.model.User;
import br.com.igorcossta.domain.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(long id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFound(String.format("User not found. ID %s", id)));
	}

	public User insert(User user) {
		return repository.save(user);
	}
}
