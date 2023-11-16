package spring.boot.tutorial.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiOldExceptionForm {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, boolean showThrowable) {
        super(message, showThrowable);
    }
}
