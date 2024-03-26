package codestartup.codestartup.common;


import org.springframework.http.HttpHeaders;

public class BaseController {

    protected HttpHeaders getSuccessHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("resultMessage", "성공");
        return httpHeaders;
    }
}
