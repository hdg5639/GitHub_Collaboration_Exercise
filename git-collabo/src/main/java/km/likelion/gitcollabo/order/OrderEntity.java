package km.likelion.gitcollabo.order;

import jakarta.persistence.*;
import km.likelion.gitcollabo.order.dto.OrderDTO;
import km.likelion.gitcollabo.product.productEntity;
import km.likelion.gitcollabo.user.UserEntity;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column
    private String orderNumber;

    @Column
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private OrderStatus status = OrderStatus.ORDER_COMPLETE;

    @Column
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private productEntity product;

    public OrderDTO toDTO() {
        return OrderDTO.builder()
                .orderId(orderId)
                .orderNumber(orderNumber)
                .status(status)
                .orderDate(orderDate)
                .OrderUserName(user.getUserName())
                .productId(product.getId())
                .productName(product.getProductName())
                .build();
    }
}
