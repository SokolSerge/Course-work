package mmsa.sokolserge.courseprojectdb.api;

import mmsa.sokolserge.courseprojectdb.dto.ProductPriceDto;
import mmsa.sokolserge.courseprojectdb.repo.model.ProductPrice;
import mmsa.sokolserge.courseprojectdb.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductPriceController {
    private final ProductPriceService productPriceService;

    @Autowired
    public ProductPriceController(ProductPriceService productPriceService){
        this.productPriceService = productPriceService;
    }
    @GetMapping(value="/productPrice")
    public ResponseEntity<List<ProductPrice>> getProductPrice(){
        return ResponseEntity.ok(productPriceService.getProductPrice());
    }

    @PostMapping(value = "/productPrice")
    public ResponseEntity<ProductPrice> postProductPrice(@RequestBody ProductPriceDto newProductPrice) {
        return ResponseEntity.ok(productPriceService.saveProductPrice(newProductPrice));
    }

    @GetMapping(value = "/productPrice/{id}")
    public ResponseEntity<ProductPrice> getProductPrice(@PathVariable Long id) {
        return ResponseEntity.ok(productPriceService.getProductPriceById(id));
    }

    @PatchMapping(value = "/productPrice/{id}")
    public ResponseEntity<ProductPrice> updateProductPrice(@PathVariable Long id, @Valid @RequestBody ProductPriceDto updatedProductPrice) {
        return ResponseEntity.ok(productPriceService.updateProductPriceById(id, updatedProductPrice));
    }

    @DeleteMapping(value = "/productPrice/{id}")
    public ResponseEntity<String> deleteProductPrice(@PathVariable Long id) {
        return ResponseEntity.ok(productPriceService.deleteProductPriceById(id));
    }
}
