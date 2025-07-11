package km.likelion.gitcollabo.order.dto;

import km.likelion.gitcollabo.order.OrderStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderDTO {
    private Long orderId;
    private String orderNumber;
    private OrderStatus status;
    private LocalDate orderDate;
    private String productName;
    private Long productId;
    private String OrderUserName;
}
