package codestartup.codestartup.common;


import org.springframework.http.HttpHeaders;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class BaseController {

    protected HttpHeaders getSuccessHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("resultMessage", URLEncoder.encode("성공", StandardCharsets.UTF_8));
        return httpHeaders;
    }
}
