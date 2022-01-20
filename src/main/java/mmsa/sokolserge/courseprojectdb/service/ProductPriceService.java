package mmsa.sokolserge.courseprojectdb.service;

import mmsa.sokolserge.courseprojectdb.dto.ProductPriceDto;
import mmsa.sokolserge.courseprojectdb.exception.ProductNotFoundException;
import mmsa.sokolserge.courseprojectdb.exception.ProductSizeNotFoundException;
import mmsa.sokolserge.courseprojectdb.exception.ProductPriceNotFoundException;
import mmsa.sokolserge.courseprojectdb.repo.model.ProductPrice;
import mmsa.sokolserge.courseprojectdb.repo.ProductRepo;
import mmsa.sokolserge.courseprojectdb.repo.ProductSizeRepo;
import mmsa.sokolserge.courseprojectdb.repo.ProductPriceRepo;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ProductPriceService {
    private final ProductPriceRepo productPriceRepo;
    private final ProductRepo productRepo;
    private final ProductSizeRepo productSizeRepo;

    public List<ProductPrice> getProductPrice(){
        return productPriceRepo.findAll();
    }

    public ProductPrice saveProductPrice(ProductPriceDto newProductPrice) {
        ProductPrice productPrice=ProductPrice.builder()
                .product(productRepo.findById(newProductPrice.getProductId()).orElseThrow(ProductNotFoundException::new))
                .productSize(productSizeRepo.findById(newProductPrice.getProductSizeId()).orElseThrow(ProductSizeNotFoundException::new))
                .price(newProductPrice.getPrice())
                .build();
        return productPriceRepo.save(productPrice);
    }

    public ProductPrice getProductPriceById(Long id) {
        Optional<ProductPrice> productPrice = productPriceRepo.findById(id);
        if (productPrice.isPresent()) {
            return productPrice.get();
        }
        throw new ProductPriceNotFoundException();
    }

    public ProductPrice updateProductPriceById(Long id, ProductPriceDto updatedProductPrice) {
        Optional<ProductPrice> productPrice = productPriceRepo.findById(id);
        if (productPrice.isPresent()) {;
            ProductPrice oldProductPrice = productPrice.get();
            updateProductPrice(oldProductPrice, updatedProductPrice);
            return productPriceRepo.save(oldProductPrice);

        }
        throw new ProductPriceNotFoundException();
    }

    private void updateProductPrice(@NotNull ProductPrice oldProductPrice, @NotNull ProductPriceDto updatedProductPrice) {
        oldProductPrice.setProduct(productRepo.findById(updatedProductPrice.getProductId()).orElseThrow(ProductNotFoundException::new));
        oldProductPrice.setProductSize(productSizeRepo.findById(updatedProductPrice.getProductSizeId()).orElseThrow(ProductSizeNotFoundException::new));
        oldProductPrice.setPrice(updatedProductPrice.getPrice());
    }

    public String deleteProductPriceById(Long id) {
        if (productPriceRepo.findById(id).isPresent()) {
            productPriceRepo.deleteById(id);
            return "Product price was successfully deleted";
        }
        throw new ProductPriceNotFoundException();
    }
}
