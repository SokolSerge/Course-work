package mmsa.sokolserge.courseprojectdb.service;
import lombok.extern.slf4j.Slf4j;
import mmsa.sokolserge.courseprojectdb.repo.ProductSizeRepo;
import mmsa.sokolserge.courseprojectdb.repo.model.ProductSize;
import mmsa.sokolserge.courseprojectdb.exception.ProductSizeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductSizeService {

    private final ProductSizeRepo productSizeRepo;

    public ProductSizeService (ProductSizeRepo productSizeRepo){
        this.productSizeRepo=productSizeRepo;
    }

    public List<ProductSize> getProductSize(){
        return productSizeRepo.findAll();
    }

    public ProductSize saveProductSize(ProductSize newProductSize) {
        return productSizeRepo.save(newProductSize);
    }

    public ProductSize getProductSizeById(Long id) {
        Optional<ProductSize> productSize = productSizeRepo.findById(id);
        if (productSize.isPresent()) {
            return productSize.get();
        }
        throw new ProductSizeNotFoundException();
    }

    public ProductSize updateProductSizeById(Long id, ProductSize updatedProductSize) {
        Optional<ProductSize> productSize = productSizeRepo.findById(id);
        if (productSize.isPresent()) {;
            ProductSize oldProductSize = productSize.get();
            updateProductSize(oldProductSize, updatedProductSize);
            return productSizeRepo.save(oldProductSize);

        }
        throw new ProductSizeNotFoundException();
    }

    private void updateProductSize(ProductSize oldProductSize, ProductSize updatedProductSize) {
        oldProductSize.setSizeType(updatedProductSize.getSizeType());
    }

    public String deleteProductSizeById(Long id) {
        if (productSizeRepo.findById(id).isPresent()) {
            productSizeRepo.deleteById(id);
            return "Product size was successfully deleted";
        }
        throw new ProductSizeNotFoundException();
    }

}
