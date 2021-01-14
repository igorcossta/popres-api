package br.com.igorcossta.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.igorcossta.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
