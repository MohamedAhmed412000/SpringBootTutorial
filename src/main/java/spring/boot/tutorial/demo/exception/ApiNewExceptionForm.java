package spring.boot.tutorial.demo.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.ZonedDateTime;

public class ApiNewExceptionForm {
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
    
    public ApiNewExceptionForm(
        String message, 
        Throwable throwable,
        HttpStatus httpStatus, 
        ZonedDateTime zonedDateTime
    ) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }
    
    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getZoneDateTime() {
        return zonedDateTime;
    }

    @Override
    public String toString() {
        return "ApiNewExceptionForm [message=" + message + ", throwable=" + throwable + ", httpStatus=" + httpStatus
                + ", ZoneDateTime=" + zonedDateTime + "]";
    }
    
}
