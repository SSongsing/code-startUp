package codestartup.codestartup.order.domain.repository;

import codestartup.codestartup.order.domain.Order;

public interface OrderRepository {
    Order saveAndFlush(Order order);
}
