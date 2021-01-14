package br.com.igorcossta.domain.exception;

public class UserNotFound extends DomainException {

	private static final long serialVersionUID = 1L;

	public UserNotFound(String msg) {
		super(msg);
	}

}
