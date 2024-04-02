package codestartup.codestartup.order.domain;

import lombok.Getter;

@Getter
public enum CategoryType {
    IT("개발"),
    FINANCIAL_TECHNOLOGY("재테크"),
    LIBERAL_ARTS("교양")
    ;
    private final String value;

    CategoryType(String value) {
        this.value = value;
    }
}
