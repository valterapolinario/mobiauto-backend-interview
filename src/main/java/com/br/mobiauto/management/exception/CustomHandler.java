package com.br.mobiauto.management.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class CustomHandler extends ResponseEntityExceptionHandler implements AccessDeniedHandler {

    @Override
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final List<FieldError> errors = ex.getFieldErrors();
        ProblemDetail detail = ProblemDetail.forStatus(BAD_REQUEST);

        Map<String, Set<Map<String, String>>> errorMap = errors.stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(fieldError -> Map.of(
                                "message", Objects.requireNonNull(fieldError.getDefaultMessage()),
                                "rejectedValue", fieldError.getRejectedValue() != null ? fieldError.getRejectedValue().toString() : "null"
                        ), Collectors.toSet())
                ));

        detail.setTitle("Validation failed");
        detail.setStatus(BAD_REQUEST.value());
        detail.setProperty("time", LocalDateTime.now
                        (ZoneId
                                .of("America/Sao_Paulo"))
                .truncatedTo(SECONDS));
        detail.setProperty("errors", errorMap);
        return ResponseEntity.status(BAD_REQUEST).body(detail);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrity(DataIntegrityViolationException ex) {
        ProblemDetail detail = ProblemDetail.forStatus(PRECONDITION_FAILED);
        detail.setTitle("Precondition failed");
        detail.setStatus(PRECONDITION_FAILED.value());
        detail.setProperty("time", LocalDateTime.now
                        (ZoneId
                                .of("America/Sao_Paulo"))
                .truncatedTo(SECONDS));
        detail.setDetail(ex.getMessage());
        return ResponseEntity.status(PRECONDITION_FAILED).body(detail);
    }

    @ExceptionHandler(ApiBussinesException.class)
    public ResponseEntity<Object> handleDataIntegrity(ApiBussinesException ex) {
        ProblemDetail detail = ProblemDetail.forStatus(BAD_REQUEST);
        detail.setTitle("bad request");
        detail.setStatus(BAD_REQUEST.value());
        detail.setProperty("time", LocalDateTime.now
                        (ZoneId
                                .of("America/Sao_Paulo"))
                .truncatedTo(SECONDS));
        detail.setDetail(ex.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(detail);
    }

    @ExceptionHandler(GeneralNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(GeneralNotFoundException ex) {
        ProblemDetail detail = ProblemDetail.forStatus(NOT_FOUND);
        detail.setTitle("Object not found");
        detail.setStatus(NOT_FOUND.value());
        detail.setProperty("time", LocalDateTime.now
                        (ZoneId
                                .of("America/Sao_Paulo"))
                .truncatedTo(SECONDS));
        detail.setProperty("value not found : ", ex.getValueNotFound());
        detail.setDetail(ex.getMessage());
        return ResponseEntity.status(NOT_FOUND).body(detail);
    }

    @ExceptionHandler(DatabaseRulesException.class)
    public ResponseEntity<Object> handleDataBaseException(DatabaseRulesException ex) {
        ProblemDetail detail = ProblemDetail.forStatus(CONFLICT);
        detail.setTitle("a conflict occurred in the database rules");
        detail.setStatus(CONFLICT.value());
        detail.setProperty("time", LocalDateTime.now
                        (ZoneId
                                .of("America/Sao_Paulo"))
                .truncatedTo(SECONDS));
        detail.setProperty("value in conflict : ", ex.getValueForConflict());
        detail.setDetail(ex.getMessage());
        return ResponseEntity.status(NOT_FOUND).body(detail);
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        return new ResponseEntity<>("Acesso não autorizado", HttpStatus.UNAUTHORIZED);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("Access Denied: " + accessDeniedException.getMessage());
        String json = String.format("{\"message\": \"%s\"}", "Acesso não autorizado: Token é inválido ou já expirou.");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
