package km.likelion.gitcollabo.order.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreateOrderDTO {

    private Long userId;
    private Long productId;
}
