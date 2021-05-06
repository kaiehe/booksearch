package ee.bcs.valiit.booksearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.awt.print.Book;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BookApplicationException.class)
    public ResponseEntity<Object> handleException(BookApplicationException e){
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse("Internal Error", 500),
        HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
