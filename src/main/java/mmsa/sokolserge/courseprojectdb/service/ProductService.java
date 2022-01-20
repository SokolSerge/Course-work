package mmsa.sokolserge.courseprojectdb.service;

import mmsa.sokolserge.courseprojectdb.dto.ProductDto;
import mmsa.sokolserge.courseprojectdb.exception.ProductGroupNotFoundException;
import mmsa.sokolserge.courseprojectdb.repo.ProductGroupRepo;
import mmsa.sokolserge.courseprojectdb.repo.ProductRepo;
import mmsa.sokolserge.courseprojectdb.repo.model.Product;
import mmsa.sokolserge.courseprojectdb.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductGroupRepo productGroupRepo;

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product saveProduct(ProductDto newProduct) {
        Product product=Product.builder()
                .productGroupId(productGroupRepo.findById(newProduct.getProductGroupId()).orElseThrow(ProductGroupNotFoundException::new))
                .productName(newProduct.getProductName())
                .build();
        return productRepo.save(product);
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new ProductNotFoundException();
    }

    public  Product updateProductById(Long id,  ProductDto updatedProduct) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {;
            Product oldProduct = product.get();
            updateProduct(oldProduct, updatedProduct);
            return productRepo.save(oldProduct);

        }
        throw new ProductNotFoundException();
    }

    private void updateProduct(Product oldProduct, ProductDto updatedProduct) {
        oldProduct.setProductName(updatedProduct.getProductName());
        oldProduct.setProductGroupId(productGroupRepo.findById(updatedProduct.getProductGroupId()).orElseThrow(ProductGroupNotFoundException::new));
    }

    public String deleteProductById(Long id) {
        if (productRepo.findById(id).isPresent()) {
            productRepo.deleteById(id);
            return "Product was successfully deleted";
        }
        throw new ProductNotFoundException();
    }
}
