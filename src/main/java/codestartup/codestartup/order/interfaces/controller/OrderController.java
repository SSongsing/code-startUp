package codestartup.codestartup.order.interfaces.controller;


import codestartup.codestartup.common.BaseController;
import codestartup.codestartup.order.application.OrderCommandService;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import codestartup.codestartup.order.domain.view.OrderBookView;
import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import codestartup.codestartup.order.interfaces.dto.OrderBookRspDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class OrderController extends BaseController {
    private final OrderCommandService orderCommandService;

    @PostMapping("/orders")
    public ResponseEntity<Object> orderBook(@RequestBody @Valid OrderBookReqDTO orderBookReqDTO) {
        // TODO: 검증
        // cmd로 만들어 주는건? -> controller
        // 할인률이 달라졌다면, 이 검증은 어디서 해야할까? -> service
        // 응집도가 떨어짐.
        // OrderVadlitor << 책임
        OrderBookCommand orderBookCommand = OrderBookCommand.builder()
                .payAmount(orderBookReqDTO.getPayAmount())
                .payMethodType(orderBookReqDTO.getPayMethod())
                .itemId(orderBookReqDTO.getItem().getId())
                .build();
        OrderBookView orderBookView = orderCommandService.orderBook(orderBookCommand);
        return new ResponseEntity<>(new OrderBookRspDTO(orderBookView), getSuccessHeaders(), HttpStatus.OK);
    }
}
