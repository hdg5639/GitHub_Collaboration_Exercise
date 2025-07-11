package km.likelion.gitcollabo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(@RequestParam String productName,
                                                  @RequestParam Long productPrice,
                                                  @RequestParam ProductCategory productCategory) {
        ProductDTO product = productService.addProduct(productName, productPrice, productCategory);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        List<ProductDTO> product = productService.getAllProducts();
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<ProductDTO> getProduct(@RequestParam Long id) {
        ProductDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PatchMapping
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product) {
        ProductDTO productDTO = productService.updateProduct(product);
        return ResponseEntity.ok(productDTO);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted product");
    }
}
