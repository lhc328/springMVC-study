package cn.java.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class GlobalExceptionHand {
	@ExceptionHandler(Exception.class)
	public String exceptionHand(Exception ex) {
		return "error.jsp";
	}
}
