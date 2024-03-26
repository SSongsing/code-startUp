package codestartup.codestartup.order.interfaces.controller;


import codestartup.codestartup.common.BaseController;
import codestartup.codestartup.order.application.OrderCommandService;
import codestartup.codestartup.order.application.BookQueryService;
import codestartup.codestartup.order.domain.view.GetBookListView;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import codestartup.codestartup.order.domain.view.OrderBookView;
import codestartup.codestartup.order.interfaces.dto.GetBookListRspDTO;
import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import codestartup.codestartup.order.interfaces.dto.OrderBookRspDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController extends BaseController {
    private final OrderCommandService orderCommandService;

    @PostMapping("/orders")
    public ResponseEntity<Object> orderBook(@RequestBody OrderBookReqDTO orderBookReqDTO) {
        OrderBookCommand orderBookCommand = OrderBookCommand.builder()
                .payAmount(orderBookReqDTO.getPayAmount())
                .payMethod(orderBookReqDTO.getPayMethod())
                .itemId(orderBookReqDTO.getItem().getId())
                .build();
        OrderBookView orderBookView = orderCommandService.orderBook(orderBookCommand);
        return new ResponseEntity<>(new OrderBookRspDTO(orderBookView), getSuccessHeaders(), HttpStatus.OK);
    }
}
