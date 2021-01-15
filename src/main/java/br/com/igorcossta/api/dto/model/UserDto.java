package br.com.igorcossta.api.dto.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.igorcossta.domain.model.User;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 255)
	private String nome;

	@NotBlank
	@Size(max = 80)
	@Email
	private String email;

	@NotNull
	@Min(value = 18)
	private int idade;

	@NotNull // (message = "{avatar.not.null}")
	private String avatar;

	public UserDto() {
	}

	public UserDto(String nome, String email, int idade, String avatar) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.avatar = avatar;
	}

	public UserDto(User user) {
		id = user.getId();
		nome = user.getNome();
		email = user.getEmail();
		idade = user.getIdade();
		avatar = user.getAvatar();
	}

	public User transformaParaObjeto() {
		return new User(nome, email, idade, avatar);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
