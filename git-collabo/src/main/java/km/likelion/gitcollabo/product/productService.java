package km.likelion.gitcollabo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class productService {
    private final productRepository productRepository;

    public productDTO addProduct(String productName, Long productPrice, ProductCategory productCategory) {
        return productRepository.save(productEntity.builder()
                        .productName(productName)
                        .productPrice(productPrice)
                        .productCategory(productCategory)
                        .build())
                .toDTO();
    }

}
