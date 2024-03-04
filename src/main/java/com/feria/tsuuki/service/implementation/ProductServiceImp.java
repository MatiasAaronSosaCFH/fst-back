package com.feria.tsuuki.service.implementation;

import com.feria.tsuuki.models.category.CategoryRequest;
import com.feria.tsuuki.models.product.Product;
import com.feria.tsuuki.models.product.ProductResponse;
import com.feria.tsuuki.models.subcategory.SubCategoryRequest;
import com.feria.tsuuki.repository.ProductRepository;
import com.feria.tsuuki.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> findAllAvailable() {
        return productRepository
                .findAllAvailable()
                .stream()
                .map(ProductResponse::new)
                .toList();
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(ProductResponse::new)
                .toList();
    }

    @Override
    public ProductResponse findProductById(Long id) {
        Optional<Product> product = productRepository.findProductById(id);
        if (product.isPresent()) return new ProductResponse(product.get());
        return null;
    }

    @Override
    public List<ProductResponse> findProductByPrice(Double min, Double max) {
        return productRepository
                .findAllByPrice(min, max)
                .stream()
                .map(ProductResponse::new)
                .toList();
    }

    @Override
    public List<ProductResponse> findProductBySubCategory(SubCategoryRequest subCategoryRequest) {
        return productRepository
                .findProductBySubCategory(subCategoryRequest.id())
                .stream()
                .map(ProductResponse::new)
                .toList();
    }

    @Override
    public List<ProductResponse> findProductByCategory(CategoryRequest categoryRequest) {
        return productRepository
                .findProductByCategory(categoryRequest.id())
                .stream()
                .map(ProductResponse::new)
                .toList();
    }
}
