package km.likelion.gitcollabo.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Long productPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory productCategory;

    public ProductDTO toDTO() {
        return ProductDTO.builder()
                .id(id)
                .productName(productName)
                .productPrice(productPrice)
                .productCategory(productCategory)
                .build();
    }
}
