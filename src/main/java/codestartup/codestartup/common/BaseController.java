package codestartup.codestartup.common;


import org.springframework.http.HttpHeaders;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class BaseController {

    protected HttpHeaders getSuccessHeaders() {
        // TODO: 팀원들에게 물어보기
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("resultMessage", URLEncoder.encode("성공", StandardCharsets.UTF_8));
        return httpHeaders;
    }
}
