package codestartup.codestartup.order.domain;

import codestartup.codestartup.common.ApiException;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum PayMethod {
    // todo: converter 추가하기?
    CASH("CASH"),
    CARD("CARD");
    private String value;

    private final static Map<String, PayMethod> values = Stream.of(values()).collect(Collectors.toMap(PayMethod::getValue, Function.identity()));

    PayMethod(String value) {
        this.value = value;
    }

    public static PayMethod fromValue(String value) {
        // todo: 어떤 exception이 나가야하나
        return Optional.ofNullable(values.get(value)).orElseThrow(() -> new ApiException("올바르지 않은 결제 방식입니다.(CASH, CARD)"));
    }

    public static boolean contains(String value) {
        return values.containsKey(value);
    }
}
