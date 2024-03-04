package com.feria.tsuuki.service.abstraction;

import com.feria.tsuuki.models.category.CategoryRequest;
import com.feria.tsuuki.models.product.ProductRequest;
import com.feria.tsuuki.models.product.ProductResponse;
import com.feria.tsuuki.models.subcategory.SubCategoryRequest;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAllAvailable();
    List<ProductResponse> findAll();
    ProductResponse findProductById(Long id);
    List<ProductResponse> findProductByPrice(Double price, Double price2);
    List<ProductResponse> findProductBySubCategory(SubCategoryRequest subCategoryRequest);
    List<ProductResponse> findProductByCategory(CategoryRequest categoryRequest);
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse makeUnAvailable(Long id);
    ProductResponse makeAvailable(Long id);
}
