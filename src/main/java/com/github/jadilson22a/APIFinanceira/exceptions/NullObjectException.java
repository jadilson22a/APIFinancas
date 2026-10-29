package com.github.jadilson22a.APIFinanceira.exceptions;

public class NullObjectException extends RuntimeException{

	public NullObjectException(String message) {
		super(message);
	}

	public NullObjectException() {
		super("Objeto não encontrado!");
	}

}
