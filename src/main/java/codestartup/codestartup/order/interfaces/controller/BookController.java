package codestartup.codestartup.order.interfaces.controller;

import codestartup.codestartup.common.BaseController;
import codestartup.codestartup.order.application.BookQueryService;
import codestartup.codestartup.order.domain.view.GetBookListView;
import codestartup.codestartup.order.interfaces.dto.GetBookListRspDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController extends BaseController {

    private final BookQueryService bookQueryService;

    @GetMapping("/books")
    public ResponseEntity<GetBookListRspDTO> getBookList() {

        GetBookListView getBookListView = bookQueryService.getBookList();
        return new ResponseEntity<>(new GetBookListRspDTO(getBookListView), getSuccessHeaders(), HttpStatus.OK);
    }
}
