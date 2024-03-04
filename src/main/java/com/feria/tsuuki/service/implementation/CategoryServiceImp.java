package com.feria.tsuuki.service.implementation;

import com.feria.tsuuki.models.category.Category;
import com.feria.tsuuki.models.category.CategoryRequest;
import com.feria.tsuuki.models.category.CategoryResponse;
import com.feria.tsuuki.repository.CategoryRepository;
import com.feria.tsuuki.repository.ProductRepository;
import com.feria.tsuuki.service.abstraction.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> findAllAvailable() {
        return categoryRepository
                .findAllAvailable()
                .stream()
                .map(CategoryResponse::new)
                .toList();
    }

    @Override
    public CategoryResponse findCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findCategoryById(id);
        if (category.isPresent())
            return new CategoryResponse(category.get());
        else
            return null;
    }

    @Override
    public CategoryResponse findCategoryByName(String name) {
        Optional<Category> category =  categoryRepository.fingCategoryByName(name);
        if (category.isPresent())
            return new CategoryResponse(category.get());
        else
            return null;
    }

    @Override
    public CategoryResponse createNewCategory(CategoryRequest categoryRequest) {
        Date now = new Date();

        Category catOp = categoryRepository.save(Category
                .builder()
                .createAt(now)
                .updateAt(now)
                .isPresent(true)
                .name(categoryRequest.name())
                .build());

        return new CategoryResponse(catOp);
    }

    @Transactional
    @Override
    public CategoryResponse updateCategory(CategoryRequest categoryRequest) {
        Date now = new Date();
        Optional<Category> catOp = categoryRepository.updateCategory(categoryRequest.name(), categoryRequest.id());

        if (catOp.isPresent()) return  new CategoryResponse(catOp.get());


        return new CategoryResponse();
    }

    @Transactional
    @Override
    public Optional<?> makeUnAvailable(Long id) {
        Optional<Category> category = categoryRepository.changeAvailable(id, false);

        if (category.isPresent()){
            return Optional.of(new CategoryResponse(category.get()));
        }

        return Optional.of(null);
    }

    @Transactional
    @Override
    public Optional<?> makeAvailable(Long id) {
        Optional<Category> category = categoryRepository.changeAvailable(id, true);

        if (category.isPresent()){
            return Optional.of(new CategoryResponse(category.get()));
        }

        return Optional.of(null);
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryResponse::new)
                .toList();
    }

}
