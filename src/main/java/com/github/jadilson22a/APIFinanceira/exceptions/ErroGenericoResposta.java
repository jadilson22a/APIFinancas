package com.github.jadilson22a.APIFinanceira.exceptions;

import org.springframework.http.HttpStatus;

public record ErroGenericoResposta(HttpStatus status, String message) {

}
