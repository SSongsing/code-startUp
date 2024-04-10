package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.PayMethod;
import codestartup.codestartup.order.domain.PayMethodType;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PayService {
    private final Map<String, PayMethod> payMethods;

    @Transactional
    public Money pay(OrderBookCommand orderBookCommand, Money price, Money discountPrice) {
        PayMethodType payMethodType = orderBookCommand.getPayMethodType();
        PayMethod payMethod = payMethods.get(payMethodType.getPayMethodName());
        return payMethod.pay(orderBookCommand.getPayAmount(), price, discountPrice);
    }
}
