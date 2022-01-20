package mmsa.sokolserge.courseprojectdb.api;

import mmsa.sokolserge.courseprojectdb.dto.ProductDto;
import mmsa.sokolserge.courseprojectdb.repo.model.Product;
import mmsa.sokolserge.courseprojectdb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping(value="/products")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }
    @PostMapping(value = "/products")
    public ResponseEntity<Product> postProduct(@RequestBody ProductDto newProduct) {
        return ResponseEntity.ok(productService.saveProduct(newProduct));
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PatchMapping(value = "/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto updatedProduct) {
        return ResponseEntity.ok(productService.updateProductById(id, updatedProduct));
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProductById(id));
    }
}
