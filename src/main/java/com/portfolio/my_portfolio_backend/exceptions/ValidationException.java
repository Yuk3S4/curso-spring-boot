package com.portfolio.my_portfolio_backend.exceptions;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class ValidationException extends RuntimeException {
    private final BindingResult bindingResult;

    public ValidationException(BindingResult bindingResult) {
        super("Error de validación: Se encontraron " + bindingResult.getErrorCount() + " errores");
        this.bindingResult = bindingResult;
    }
}
