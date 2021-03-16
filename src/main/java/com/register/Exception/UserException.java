package com.register.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.register.bean.ErrorBean;

@ControllerAdvice
public class UserException {
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorBean> exception(UserNotFoundException exception) {
		//System.out.println("Entered in User not found global exception");
		ErrorBean bean = new ErrorBean();
		bean.setErrorMsg(exception.getMessage());
		return new ResponseEntity<>(bean, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ErrorBean> exceptionNullPointer(NullPointerException exception) {
		//System.out.println("Entered in User not found global exception");
		ErrorBean bean = new ErrorBean();
		bean.setErrorMsg(exception.getMessage());
		return new ResponseEntity<>(bean, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorBean> exceptionSuper(Exception exception) {
		//System.out.println("Entered in User not found global exception");
		ErrorBean bean = new ErrorBean();
		bean.setErrorMsg(exception.getMessage());
		return new ResponseEntity<>(bean, HttpStatus.NOT_FOUND);
	}

}
