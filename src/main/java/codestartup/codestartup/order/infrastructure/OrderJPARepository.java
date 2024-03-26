package codestartup.codestartup.order.infrastructure;

import codestartup.codestartup.order.domain.Order;
import codestartup.codestartup.order.domain.repository.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJPARepository extends OrderRepository, JpaRepository<Order, Integer> {
    Order saveAndFlush(Order order);
}
