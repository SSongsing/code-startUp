package codestartup.codestartup.order.infrastructure;

import codestartup.codestartup.order.domain.Order;
import codestartup.codestartup.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryOrderRepository implements OrderRepository {
    private Map<Long, Order> store = new HashMap<>();
    @Override
    public Order saveAndFlush(Order order) {
        store.put(order.getId(), order);
        return order;
    }
}
