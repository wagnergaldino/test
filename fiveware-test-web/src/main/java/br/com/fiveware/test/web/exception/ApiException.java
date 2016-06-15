package br.com.fiveware.test.web.exception;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 7240707621951834593L;

	public ApiException(String msg){
		super(msg);
	}

}