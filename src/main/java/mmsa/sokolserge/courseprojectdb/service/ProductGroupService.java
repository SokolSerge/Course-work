package mmsa.sokolserge.courseprojectdb.service;
import lombok.extern.slf4j.Slf4j;
import mmsa.sokolserge.courseprojectdb.repo.ProductGroupRepo;
import mmsa.sokolserge.courseprojectdb.repo.model.ProductGroup;
import mmsa.sokolserge.courseprojectdb.exception.ProductGroupNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductGroupService {

    private final ProductGroupRepo productGroupRepo;

    public ProductGroupService (ProductGroupRepo productGroupRepo){
        this.productGroupRepo=productGroupRepo;
    }

    public List<ProductGroup> getProductGroup(){
        return productGroupRepo.findAll();
    }

    public ProductGroup saveProductGroup(ProductGroup newProductGroup) {
        return productGroupRepo.save(newProductGroup);
    }

    public ProductGroup getProductGroupById(Long id) {
        Optional<ProductGroup> productGroup = productGroupRepo.findById(id);
        if (productGroup.isPresent()) {
            return productGroup.get();
        }
        throw new ProductGroupNotFoundException();
    }

    public ProductGroup updateProductGroupById(Long id, ProductGroup updatedProductGroup) {
        Optional<ProductGroup> productGroup = productGroupRepo.findById(id);
        if (productGroup.isPresent()) {;
            ProductGroup oldProductGroup = productGroup.get();
            updateProductGroup(oldProductGroup, updatedProductGroup);
            return productGroupRepo.save(oldProductGroup);

        }
        throw new ProductGroupNotFoundException();
    }

    private void updateProductGroup(ProductGroup oldProductGroup, ProductGroup updatedProductGroup) {
        oldProductGroup.setGroupType(updatedProductGroup.getGroupType());
    }

    public String deleteProductGroupById(Long id) {
        if (productGroupRepo.findById(id).isPresent()) {
            productGroupRepo.deleteById(id);
            return "Product group was successfully deleted";
        }
        throw new ProductGroupNotFoundException();
    }

}