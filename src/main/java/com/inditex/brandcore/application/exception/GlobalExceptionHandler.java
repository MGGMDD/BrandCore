package com.inditex.brandcore.application.exception;

import com.inditex.brandcore.application.exception.error.ErrorData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorData handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        String message = messageSource.getMessage("error.message.arguments", null, locale);
        return ErrorData.builder().codResponse(CustomMethodArgumentNotValidException.ERROR_CODE)
                .descResponse(message + " " + ex.getBindingResult().getFieldErrors()
                        .stream().map(FieldError::getField).collect(Collectors.joining(", "))).build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BrandNotFoundException.class)
    public ErrorData handleBrandNotFoundException(BrandNotFoundException ex, Locale locale) {
        String message = messageSource.getMessage("error.message.brand.notfound", null, locale);
        return ErrorData.builder().codResponse(CustomMethodArgumentNotValidException.ERROR_CODE)
                .descResponse(message).build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PriceNotFoundException.class)
    public ErrorData handlePriceNotFoundException(PriceNotFoundException ex, Locale locale) {
        String message = messageSource.getMessage("error.message.price.notfound", null, locale);
        return ErrorData.builder().codResponse(CustomMethodArgumentNotValidException.ERROR_CODE)
                .descResponse(message).build();
    }


}
