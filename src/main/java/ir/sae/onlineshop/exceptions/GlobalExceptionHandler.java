package ir.sae.onlineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


    @ExceptionHandler(BaseException.class)
    public String handle(BaseException e){
        System.out.println(e.getMessage());
        return e.getMessage() ;
    }



//    @ExceptionHandler(RuntimeException.class)
//    public @ResponseBody ErrorResponse roleNotFound(RuntimeException runtimeException){
//        return ErrorResponse.of(runtimeException.getMessage(),HttpStatus.BAD_REQUEST.value());
//    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse wrongFormat(RuntimeException runtimeException){
        return ErrorResponse.of("just entered number",HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse wrong(RuntimeException runtimeException){
        return ErrorResponse.of("NULL",HttpStatus.BAD_REQUEST.value());
    }

}
