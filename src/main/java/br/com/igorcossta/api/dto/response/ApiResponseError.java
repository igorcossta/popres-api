package br.com.igorcossta.api.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ApiResponseError implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", locale = "en-US")
	private LocalDateTime time;
	private String title;

	private List<Campo> campos;

	public ApiResponseError() {
	}

	public ApiResponseError(int code, LocalDateTime time, String title, List<Campo> campos) {
		super();
		this.code = code;
		this.time = time;
		this.title = title;
		this.campos = campos;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	/**
	 *
	 * 
	 * create an object to return field errors in response
	 * 
	 */

	public static class Campo implements Serializable {
		private static final long serialVersionUID = 1L;

		private String message;
		private String field;
		private Object parameter;

		public Campo() {
		}

		public Campo(String message, String field, Object parameter) {
			this.message = message;
			this.field = field;
			this.parameter = parameter;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public Object getParameter() {
			return parameter;
		}

		public void setParameter(Object parameter) {
			this.parameter = parameter;
		}

	}

}
