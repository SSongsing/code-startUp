package codestartup.codestartup.order.interfaces.controller;


import codestartup.codestartup.order.application.OrderQueryService;
import codestartup.codestartup.order.domain.GetBookListView;
import codestartup.codestartup.order.interfaces.dto.GetBookListRspDTO;
import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderQueryService orderQueryService;
    @GetMapping("/books")
    public ResponseEntity<GetBookListRspDTO> getBookList() {
        GetBookListView getBookListView = orderQueryService.getBookList();
        return new ResponseEntity<>(new GetBookListRspDTO(getBookListView), HttpStatus.OK);
    }

    @PostMapping("/books/orders")
    public ResponseEntity<Object> orderBook(@RequestBody OrderBookReqDTO orderBookReqDTO) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
