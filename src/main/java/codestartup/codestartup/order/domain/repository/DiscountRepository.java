package codestartup.codestartup.order.domain.repository;

import codestartup.codestartup.order.domain.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountRepository {
    Optional<Discount> findById(Long id);
}
