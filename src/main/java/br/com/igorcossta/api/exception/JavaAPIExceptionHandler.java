package br.com.igorcossta.api.exception;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.igorcossta.api.dto.response.ApiResponseError;
import br.com.igorcossta.domain.exception.UserNotFound;

@RestControllerAdvice
public class JavaAPIExceptionHandler extends ResponseEntityExceptionHandler {
	private final String AN_ERROR_OCCURRED = "An error has occurred. Try again";

	/**
	 * Method that handles with a ArgumentNotValidException and returns an error
	 * with status code = 400.
	 */

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		var title = "Campos inválidos. Por favor verique e tente novamente.";
		var fields = returnErrors(ex);
		var response = new ApiResponseError(status.value(), OffsetDateTime.now(), title, fields);

		return super.handleExceptionInternal(ex, response, headers, status, request);
	}

	/**
	 * Method that handles with a UserNotFoundException and returns an error with
	 * status code = 404.
	 * 
	 * @author Igor Costa
	 * @since 06/01/2021
	 * 
	 * @param ex
	 * @return ResponseEntity
	 */

	@ExceptionHandler({ UserNotFound.class })
	protected ResponseEntity<Object> handleMethodUserNotFound(UserNotFound ex, WebRequest request) {

		var status = HttpStatus.NOT_FOUND;
		var title = ex.getMessage();

		var res = new ApiResponseError(status.value(), OffsetDateTime.now(), title, null);
		return handleExceptionInternal(ex, res, new HttpHeaders(), status, request);
	}

	/**
	 * Method to return a list of field errors of ArgumentNotValidException
	 * 
	 * 
	 * @param ex
	 * @return error list
	 */

	private List<ApiResponseError.Campo> returnErrors(MethodArgumentNotValidException ex) {
		return ex.getBindingResult().getFieldErrors().stream()
				.map(error -> new ApiResponseError.Campo(error.getDefaultMessage(), error.getField(),
						error.getRejectedValue()))
				.collect(Collectors.toList());
	}

}
