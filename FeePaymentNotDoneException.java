package com.g3.spc.exception;

public class FeePaymentNotDoneException  extends Exception{
	

	private String message = "";

	public FeePaymentNotDoneException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeePaymentNotDoneException(String message) {
		super();
		this.message = message;
	}


	public FeePaymentNotDoneException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FeePaymentNotDoneException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	
	public FeePaymentNotDoneException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FeePaymentNotDoneException [message=" + message + "]";
	}
	
	

}
