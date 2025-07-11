package km.likelion.gitcollabo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;

    public ProductDTO addProduct(String productName, Long productPrice, ProductCategory productCategory) {
        return productRepository.save(ProductEntity.builder()
                        .productName(productName)
                        .productPrice(productPrice)
                        .productCategory(productCategory)
                        .build())
                .toDTO();
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductEntity::toDTO)
                .toList();
    }

    public ProductDTO getProduct(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("product not found"));
                return product.toDTO();
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        ProductEntity product = productRepository.findById(productDTO.getId()).orElseThrow(()->new RuntimeException("product not found"));
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductCategory(productDTO.getProductCategory());
        return product.toDTO();
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
