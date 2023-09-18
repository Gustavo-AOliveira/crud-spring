package br.com.web.Exercicio2.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class exception{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException exception){
        var errors = exception.getFieldErrors();
            return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new).toList());
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
    private record DadosErroValidacao(String field, String message) {
        private DadosErroValidacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}

