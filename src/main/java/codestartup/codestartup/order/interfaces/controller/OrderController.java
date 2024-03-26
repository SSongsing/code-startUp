package codestartup.codestartup.order.interfaces.controller;


import codestartup.codestartup.order.application.OrderCommandService;
import codestartup.codestartup.order.application.OrderQueryService;
import codestartup.codestartup.order.domain.view.GetBookListView;
import codestartup.codestartup.order.domain.OrderBookCommand;
import codestartup.codestartup.order.domain.view.OrderBookView;
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
    private final OrderCommandService orderCommandService;

    @GetMapping("/books")
    public ResponseEntity<GetBookListRspDTO> getBookList() {
        GetBookListView getBookListView = orderQueryService.getBookList();
        return new ResponseEntity<>(new GetBookListRspDTO(getBookListView), HttpStatus.OK);
    }

    @PostMapping("/books/orders")
    public ResponseEntity<Object> orderBook(@RequestBody OrderBookReqDTO orderBookReqDTO) {
        OrderBookCommand orderBookCommand = OrderBookCommand.builder()
                .payAmount(orderBookReqDTO.getPayAmount())
                .payMethod(orderBookReqDTO.getPayMethod())
                .itemId(orderBookReqDTO.getItem().getId())
                .build();
        OrderBookView orderBookView = orderCommandService.orderBook(orderBookCommand);
        return new ResponseEntity<>(orderBookView, HttpStatus.OK);
    }
}
