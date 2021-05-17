package com.surittec.avaliacao.api.exception;

import com.surittec.avaliacao.api.exception.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Order(-1)
@ControllerAdvice
@RequiredArgsConstructor
public class AdvisorController {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClienteNotFoundException.class)
    public ErrorResponse clienteNotFoundExceptionHandler(ClienteNotFoundException ex) {
        return new ErrorResponse(ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidTypeException.class)
    public ErrorResponse invalidTypeExceptionHandler(InvalidTypeException ex) {
        return new ErrorResponse(ex.getClass().getSimpleName(), ex.getMessage());
    }
}
