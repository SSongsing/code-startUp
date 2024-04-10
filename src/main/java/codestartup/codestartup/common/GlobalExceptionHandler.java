package codestartup.codestartup.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.springframework.http.HttpHeaders;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestControllerAdvice // 도메인
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private HttpHeaders setHeaders(String message) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("resultMessage", URLEncoder.encode(message, StandardCharsets.UTF_8));
        return httpHeaders;
    }


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException ae) {
        HttpHeaders httpHeaders = setHeaders(ae.getMessage());
        return new ResponseEntity<>(httpHeaders, ae.getHttpStatus());
    }
}
