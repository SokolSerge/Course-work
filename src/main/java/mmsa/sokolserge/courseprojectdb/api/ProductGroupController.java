package mmsa.sokolserge.courseprojectdb.api;

import mmsa.sokolserge.courseprojectdb.repo.model.ProductGroup;
import mmsa.sokolserge.courseprojectdb.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
public class ProductGroupController {

    private final ProductGroupService productGroupService;

    @Autowired
    public ProductGroupController(ProductGroupService productGroupService){
    this.productGroupService=productGroupService;
    }

    @GetMapping(value="/productGroups")
    public ResponseEntity<List<ProductGroup>> getProductGroup(){
        return ResponseEntity.ok(productGroupService.getProductGroup());
    }

    @PostMapping(value = "/productGroups")
    public ResponseEntity<ProductGroup> postProductGroup(@Valid @RequestBody ProductGroup newProductGroup) {
        return ResponseEntity.ok(productGroupService.saveProductGroup(newProductGroup));
    }

    @GetMapping(value = "/productGroups/{id}")
    public ResponseEntity<ProductGroup> getProductGroup(@PathVariable Long id) {
        return ResponseEntity.ok(productGroupService.getProductGroupById(id));
    }

    @PatchMapping(value = "/productGroups/{id}")
    public ResponseEntity<ProductGroup> updateProductGroup(@PathVariable Long id, @Valid @RequestBody ProductGroup updatedProductGroup) {
        return ResponseEntity.ok(productGroupService.updateProductGroupById(id, updatedProductGroup));
    }

    @DeleteMapping(value = "/productGroups/{id}")
    public ResponseEntity<String> deleteProductGroup(@PathVariable Long id) {
        return ResponseEntity.ok(productGroupService.deleteProductGroupById(id));
    }
}