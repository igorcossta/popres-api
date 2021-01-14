package br.com.igorcossta.api.dto.response;

import java.io.Serializable;

import br.com.igorcossta.domain.model.User;

@Deprecated
public class UserResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private int idade;
	private String avatar;

	public UserResponseDto() {
	}

	public UserResponseDto(Long id, String nome, int idade, String avatar) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.avatar = avatar;
	}

	public static UserResponseDto transformaEmDto(User user) {
		return new UserResponseDto(user.getId(), user.getNome(), user.getIdade(), user.getAvatar());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
