package ir.sae.onlineshop.exceptions;

public class BaseException extends Exception{

    private final String exceptionType;

    private final Integer errorCode;

    public Integer getErrorCode() {
        return errorCode;
    }

    public BaseException(String exceptionType, Integer errorCode) {
        super();
        this.exceptionType = exceptionType;
        this.errorCode = errorCode;
    }

    public BaseException(String message, String exceptionType, Integer errorCode) {
        super(message);
        this.exceptionType = exceptionType;
        this.errorCode = errorCode;
    }

    public BaseException(String message, Throwable cause, String exceptionType, Integer errorCode) {
        super(message, cause);
        this.exceptionType = exceptionType;
        this.errorCode = errorCode;
    }

    public BaseException(Throwable cause, String exceptionType, Integer errorCode) {
        super(cause);
        this.exceptionType = exceptionType;
        this.errorCode = errorCode;
    }

    protected BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String exceptionType, Integer errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionType = exceptionType;
        this.errorCode = errorCode;
    }

    public String getExceptionType() {
        return exceptionType;
    }
}
