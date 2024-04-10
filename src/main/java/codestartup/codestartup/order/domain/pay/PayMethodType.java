package codestartup.codestartup.order.domain.pay;

import codestartup.codestartup.common.ApiException;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum PayMethodType {
    // todo: converter 추가하기?
    CASH("CASH", "CashPayMethod"),
    CARD("CARD", "CardPayMethod");
    private final String value;
    private final String payMethodName;

    private final static Map<String, PayMethodType> values = Stream.of(values()).collect(Collectors.toMap(PayMethodType::getValue, Function.identity()));

    PayMethodType(String value, String payMethodName) {

        this.value = value;
        this.payMethodName = payMethodName;
    }

    public static PayMethodType fromValue(String value) {
        // todo: 어떤 exception이 나가야하나
        return Optional.ofNullable(values.get(value)).orElseThrow(() -> new ApiException("올바르지 않은 결제 방식입니다.(CASH, CARD)"));
    }

    public static boolean contains(String value) {
        return values.containsKey(value);
    }
}
