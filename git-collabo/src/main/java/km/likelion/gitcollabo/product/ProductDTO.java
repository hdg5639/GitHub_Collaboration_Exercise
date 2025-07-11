package km.likelion.gitcollabo.product;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO {
    private Long id;
    private String productName;
    private Long productPrice;
    private ProductCategory productCategory;
}