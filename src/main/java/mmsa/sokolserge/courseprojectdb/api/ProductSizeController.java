package mmsa.sokolserge.courseprojectdb.api;

import mmsa.sokolserge.courseprojectdb.repo.model.ProductSize;
import mmsa.sokolserge.courseprojectdb.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductSizeController {

    private final ProductSizeService productSizeService;

    @Autowired
    public ProductSizeController(ProductSizeService productSizeService){
        this.productSizeService=productSizeService;
    }

    @GetMapping(value="/productSizes")
    public ResponseEntity<List<ProductSize>> getProductSize(){
        return ResponseEntity.ok(productSizeService.getProductSize());
    }

    @PostMapping(value = "/productSizes")
    public ResponseEntity<ProductSize> postProductSize(@Valid @RequestBody ProductSize newProductSize) {
        return ResponseEntity.ok(productSizeService.saveProductSize(newProductSize));
    }

    @GetMapping(value = "/productSizes/{id}")
    public ResponseEntity<ProductSize> getProductSize(@PathVariable Long id) {
        return ResponseEntity.ok(productSizeService.getProductSizeById(id));
    }

    @PatchMapping(value = "/productSizes/{id}")
    public ResponseEntity<ProductSize> updateProductSize(@PathVariable Long id, @Valid @RequestBody ProductSize updatedProductSize) {
        return ResponseEntity.ok(productSizeService.updateProductSizeById(id, updatedProductSize));
    }

    @DeleteMapping(value = "/productSizes/{id}")
    public ResponseEntity<String> deleteProductSize(@PathVariable Long id) {
        return ResponseEntity.ok(productSizeService.deleteProductSizeById(id));
    }
}