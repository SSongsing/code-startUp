package codestartup.codestartup.order.domain;

import lombok.Getter;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum PayMethodType {
    CASH("CASH"),
    CARD("CARD");
    private String value;

    private final static HashSet<String> values = Stream.of(values()).map(PayMethodType::getValue).collect(Collectors.toCollection(HashSet::new));

    PayMethodType(String value) {
        this.value = value;
    }

}
