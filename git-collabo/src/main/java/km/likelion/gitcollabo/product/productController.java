package km.likelion.gitcollabo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor

public class productController {
    private final productService productService;

    @PostMapping
    public ResponseEntity<productDTO> saveProduct(@RequestParam String productName,
                                                  @RequestParam Long productPrice,
                                                  @RequestParam ProductCategory productCategory) {
        productDTO product = productService.addProduct(productName, productPrice, productCategory);
        return ResponseEntity.ok(product);
    }



}
