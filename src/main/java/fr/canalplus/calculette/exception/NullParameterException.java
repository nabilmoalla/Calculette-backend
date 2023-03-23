package fr.canalplus.calculette.exception;

public class NullParameterException extends RuntimeException {

    private String message;

    public NullParameterException() {
        super();
    }

    public NullParameterException(Throwable cause) {
        super(cause);
    }

    public NullParameterException(String msg) {
        super(msg);
        this.message = msg;
    }


    public NullParameterException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }


}
