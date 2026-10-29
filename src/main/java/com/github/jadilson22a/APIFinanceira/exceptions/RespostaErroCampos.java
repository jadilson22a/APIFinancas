package com.github.jadilson22a.APIFinanceira.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

public record RespostaErroCampos(HttpStatus status, String erroMessage, List<CampoErro> campos) {

}
