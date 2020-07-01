package com.ashelsha.filesorter.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@ControllerAdvice
public class FileSorterException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<FileSorterExceptionErrorMessage> handleExceptionFile(Exception ex, WebRequest request)
			throws Exception {
		FileSorterExceptionErrorMessage errorMessage = new FileSorterExceptionErrorMessage(ex.getMessage().toString(),
				LocalDateTime.now().toLocalDate(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		// TODO Auto-generated method stub
		
		return super.handleBindException(ex, headers, status, request);
	}

}

@JsonFormat
@JsonPropertyOrder({ "errorMesssage", "localDate", "httpStatus" })
class FileSorterExceptionErrorMessage extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100L;
	private String errorMesssage;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDate localDate;
	private int httpStatus;

	FileSorterExceptionErrorMessage() {
	}

	FileSorterExceptionErrorMessage(String errorMessage, LocalDate localDate, int httpStatus) {
		this.errorMesssage = errorMessage;
		this.localDate = localDate;
		this.httpStatus = httpStatus;
	}
}