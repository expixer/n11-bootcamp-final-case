package com.sezginsevinc.finalcase.general;

import com.sezginsevinc.finalcase.error.GeneralErrorMessages;
import com.sezginsevinc.finalcase.error.exceptions.ItemNotFoundException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
@RequiredArgsConstructor
public class GeneralControllerAdvice extends ResponseEntityExceptionHandler {


  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                HttpStatusCode status, WebRequest request) {
    List<Map<String, String>> errorList = ex.getBindingResult().getFieldErrors().stream()
                                            .map(fieldError ->
                                                 {
                                                   Map<String, String> errorMap = new HashMap<>();
                                                   errorMap.put(fieldError.getField(),
                                                                fieldError.getDefaultMessage());
                                                   return errorMap;
                                                 }).toList();

    String description = request.getDescription(false);

    var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), errorList.toString(), description);
    var restResponse = RestResponse.error(generalErrorMessages);

    return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler
  public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {

    String message = e.getMessage();
    String description = request.getDescription(false);

    var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
    var restResponse = RestResponse.error(generalErrorMessages);

    return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler
  public final ResponseEntity<Object> handleAllExceptions(TransactionSystemException e, WebRequest request) {

    String message = Objects.requireNonNull(e.getOriginalException()).getCause().getMessage();
    String description = request.getDescription(false);

    var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
    var restResponse = RestResponse.error(generalErrorMessages);

    return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler
  public final ResponseEntity<Object> handleRTExceptions(ItemNotFoundException e, WebRequest request) {

    String message = e.getMessage();
    String description = request.getDescription(false);

    var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
    var restResponse = RestResponse.error(generalErrorMessages);

    return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public final ResponseEntity<Object> handleRTExceptions(BusinessException e, WebRequest request) {

    String message = e.getBaseErrorMessage().getMessage();
    String description = request.getDescription(false);

    var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
    var restResponse = RestResponse.error(generalErrorMessages);

    return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
  }
}
