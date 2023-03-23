package fr.canalplus.calculette.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(NullParameterException.class)
    protected ResponseEntity<Object> handleEntityNotFound(NullParameterException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
}
