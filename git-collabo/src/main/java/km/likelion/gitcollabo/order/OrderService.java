package km.likelion.gitcollabo.order;

import km.likelion.gitcollabo.order.dto.CreateOrderDTO;
import km.likelion.gitcollabo.order.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;

    public OrderDTO createOrder(CreateOrderDTO createOrderDTO) {
        return orderDAO.createOrder(createOrderDTO);
    }

    public List<OrderDTO> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public List<OrderDTO> getOrdersByUser(Long userId) {
        return orderDAO.getOrdersByUser(userId);
    }

    public OrderDTO changeOrderStatus(Long orderId, OrderStatus orderStatus) {
        return orderDAO.changeOrderStatus(orderId, orderStatus);
    }
}
