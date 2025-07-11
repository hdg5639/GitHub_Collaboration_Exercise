package km.likelion.gitcollabo.order;

import km.likelion.gitcollabo.order.dto.CreateOrderDTO;
import km.likelion.gitcollabo.order.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        OrderDTO orderDTO = orderService.createOrder(createOrderDTO);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/user")
    public ResponseEntity<List<OrderDTO>> getUserOrders(@RequestParam Long userId) {
        List<OrderDTO> orderDTO = orderService.getOrdersByUser(userId);
        return ResponseEntity.ok(orderDTO);
    }

    @PutMapping("/status-change")
    public ResponseEntity<OrderDTO> changeOrderStatus(@RequestParam Long orderId, @RequestParam OrderStatus orderStatus) {
        OrderDTO orderDTO = orderService.changeOrderStatus(orderId, orderStatus);
        return ResponseEntity.ok(orderDTO);
    }
}
