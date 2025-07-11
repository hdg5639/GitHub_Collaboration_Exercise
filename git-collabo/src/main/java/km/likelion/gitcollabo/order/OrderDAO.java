package km.likelion.gitcollabo.order;

import km.likelion.gitcollabo.order.dto.CreateOrderDTO;
import km.likelion.gitcollabo.order.dto.OrderDTO;
import km.likelion.gitcollabo.product.ProductRepository;
import km.likelion.gitcollabo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    //주문 번호 생성
    public static String generateOrderNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentTime = dateFormat.format(new Date());
        String randomNumber = generateRandomNumber(6); // 주문번호의 랜덤한 숫자 부분 길이 (여기서는 6자리로 설정)

        return currentTime + randomNumber;
    }

    //난수 생성
    public static String generateRandomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(10);
            sb.append(randomNumber);
        }

        return sb.toString();
    }

    public OrderDTO createOrder(CreateOrderDTO createOrderDTO) {
        OrderEntity orderEntity = OrderEntity.builder()
                .user(userRepository.findById(createOrderDTO.getUserId()).orElseThrow(() -> new RuntimeException("User Id가 없습니다.")))
                .product(productRepository.findById(createOrderDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product Id가 없습니다.")))
                .orderNumber(generateOrderNumber())
                .orderDate(LocalDate.now())
                .build();
        return orderRepository.save(orderEntity).toDTO();
    }

    //전체 주문 내역 조회
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(OrderEntity::toDTO).collect(Collectors.toList());
    }

    // 유저별 주문 내역 조회
    public List<OrderDTO> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId).stream().map(OrderEntity::toDTO).collect(Collectors.toList());
    }

    //주문 상태변경
    public OrderDTO changeOrderStatus(Long orderId, OrderStatus orderStatus) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("order id가 없다."));
        orderEntity.setStatus(orderStatus);
        return orderRepository.save(orderEntity).toDTO();
    }

}
