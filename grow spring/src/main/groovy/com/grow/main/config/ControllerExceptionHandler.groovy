package com.grow.main.config

import com.grow.main.excepciones.ApiError
import com.grow.main.excepciones.ApiException

import javax.servlet.http.HttpServletRequest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.NoHandlerFoundException

@ControllerAdvice
 class ControllerExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class)

    @ExceptionHandler(NoHandlerFoundException.class)
     ResponseEntity<ApiError> noHandlerFoundException(HttpServletRequest req, NoHandlerFoundException ex) {
        ApiError apiError = new ApiError("route_not_found", String.format("Route %s not found", req.getRequestURI()), HttpStatus.NOT_FOUND.value())
        return ResponseEntity.status(apiError.getStatus())
                .body(apiError)
    }

    @ExceptionHandler(value = ApiException.class)
    protected ResponseEntity<ApiError> handleApiException(ApiException e) {
        Integer statusCode = e.getStatusCode()
        boolean expected = HttpStatus.INTERNAL_SERVER_ERROR.value() > statusCode
        if (expected) {
            LOGGER.warn("Internal Api warn. Status Code: " + statusCode, e)
        } else {
            LOGGER.error("Internal Api error. Status Code: " + statusCode, e)
        }

        ApiError apiError = new ApiError(e.getCode(), e.getDescription(), statusCode)
        return ResponseEntity.status(apiError.getStatus())
                .body(apiError)
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ApiError> handleUnknownException(Exception e) {
        LOGGER.error("Internal error", e)

        ApiError apiError = new ApiError("internal_error", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value())
        return ResponseEntity.status(apiError.getStatus())
                .body(apiError)
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    protected ResponseEntity<ApiError> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        LOGGER.error("Bad request in JSON", e)

        ApiError apiError = new ApiError("Invalid format data JSON", "Bad request in JSON", HttpStatus.BAD_REQUEST.value())
        return ResponseEntity.status(apiError.getStatus())
                .body(apiError)
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentTypeMismatchException e) {
        LOGGER.error("Bad request in url", e)

        String name = e.getName()
        String type = e.getRequiredType().getSimpleName()
        Object value = e.getValue()
        String message = String.format("'%s' should be a valid '%s' and '%s' isn't",
                name, type, value)

        ApiError apiError = new ApiError("Invalid format data url", message, HttpStatus.BAD_REQUEST.value())
        return ResponseEntity.status(apiError.getStatus())
                .body(apiError)

    }

}
