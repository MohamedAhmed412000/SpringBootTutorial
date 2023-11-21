package spring.boot.tutorial.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

// To make this class run through all the other packages
@ControllerAdvice
public class ApiExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(value = ApiOldExceptionForm.class)
    public ResponseEntity<Object> handleApiRequestException(
        ApiOldExceptionForm apiOldExceptionForm
    ) {
        ApiNewExceptionForm apiNewExceptionForm = new ApiNewExceptionForm(
            apiOldExceptionForm.getMessage(), 
            apiOldExceptionForm.getShowThrowable()? apiOldExceptionForm: null,
            HttpStatus.BAD_REQUEST, 
            ZonedDateTime.now());

        return new ResponseEntity<>(apiNewExceptionForm, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(
        NotFoundException notFoundException
    ) {
        ApiNewExceptionForm apiNewExceptionForm = new ApiNewExceptionForm(
            notFoundException.getMessage(), 
            notFoundException.getShowThrowable()? notFoundException: null,
            HttpStatus.NOT_FOUND, 
            ZonedDateTime.now());

        return new ResponseEntity<>(apiNewExceptionForm, HttpStatus.NOT_FOUND);
    }

}
