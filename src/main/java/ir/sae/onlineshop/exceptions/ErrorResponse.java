package ir.sae.onlineshop.exceptions;

public class ErrorResponse {
    private Integer errorCode;

    private String message;

    public static ErrorResponse of(String message, Integer errorCode){
        return new ErrorResponse(errorCode,message);
    }

    public ErrorResponse(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorResponse() {
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
