package codestartup.codestartup.order.interfaces.controller;


import codestartup.codestartup.common.BaseController;
import codestartup.codestartup.order.application.OrderCommandService;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import codestartup.codestartup.order.domain.view.OrderBookView;
import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import codestartup.codestartup.order.interfaces.dto.OrderBookRspDTO;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
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
        OrderBookCommand orderBookCommand = new OrderBookCommand(orderBookReqDTO);
        OrderBookView orderBookView = orderCommandService.orderBook(orderBookCommand);
        return new ResponseEntity<>(new OrderBookRspDTO(orderBookView), getSuccessHeaders(), HttpStatus.OK);
    }
}
