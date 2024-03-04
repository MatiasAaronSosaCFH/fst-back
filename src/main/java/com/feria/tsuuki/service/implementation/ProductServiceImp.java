package com.feria.tsuuki.service.implementation;

import com.feria.tsuuki.models.category.Category;
import com.feria.tsuuki.models.category.CategoryRequest;
import com.feria.tsuuki.models.product.Product;
import com.feria.tsuuki.models.product.ProductRequest;
import com.feria.tsuuki.models.product.ProductResponse;
import com.feria.tsuuki.models.subcategory.SubCategory;
import com.feria.tsuuki.models.subcategory.SubCategoryRequest;
import com.feria.tsuuki.repository.CategoryRepository;
import com.feria.tsuuki.repository.ProductRepository;
import com.feria.tsuuki.repository.SubCategoryRepository;
import com.feria.tsuuki.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

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

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {

        SubCategory subCategory = subCategoryRepository
                .findSubCategoryById(productRequest
                        .subCategoryRequest()
                        .id())
                .orElse(null);

        Category category = categoryRepository
                .findCategoryById(productRequest
                        .categoryRequest()
                        .id())
                .orElse(null);

        Date create = new Date();

        Map<String, Integer> measures = new HashMap<>();

        List<String> keys = productRequest.measureKey();
        List<Integer> values = productRequest.measureValue();

        Iterator<Integer> iterVal = values.iterator();
        Iterator<String> iterKey = keys.iterator();

        while (iterKey.hasNext() && iterVal.hasNext()){
            measures.put(iterKey.next(),iterVal.next());
        }

        Product prod = Product
                .builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .createAt(create)
                .updateAt(create)
                .category(category)
                .measure(measures)
                .subCategory(subCategory)
                .build();

        return new ProductResponse(productRepository.save(prod));
    }

    @Override
    public ProductResponse makeUnAvailable(Long id) {
        Optional<Product> prod = productRepository.changeAvailable(false, id);
        if (prod.isPresent()) return new ProductResponse(prod.get());
        return new ProductResponse(null);
    }

    @Override
    public ProductResponse makeAvailable(Long id) {
        Optional<Product> prod = productRepository.changeAvailable(true, id);
        if (prod.isPresent()) return new ProductResponse(prod.get());
        return new ProductResponse(null);
    }
    }
}
