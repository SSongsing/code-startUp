package codestartup.codestartup.order.domain.view;

import codestartup.codestartup.order.domain.view.GetBookView;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetBookListView {
    private List<GetBookView> bookList;

    public GetBookListView(List<GetBookView> bookList) {
        this.bookList = new ArrayList<>(bookList);
    }
}
