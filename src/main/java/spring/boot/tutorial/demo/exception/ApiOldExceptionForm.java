package spring.boot.tutorial.demo.exception;

public class ApiOldExceptionForm extends RuntimeException {
    private Boolean showThrowable = false;

    public ApiOldExceptionForm(String message) {
        super(message);
    }

    public ApiOldExceptionForm(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ApiOldExceptionForm(String message, Boolean showThrowable) {
        super(message);
        this.showThrowable = showThrowable;
    }

    public Boolean getShowThrowable() {
        return showThrowable;
    }

}
