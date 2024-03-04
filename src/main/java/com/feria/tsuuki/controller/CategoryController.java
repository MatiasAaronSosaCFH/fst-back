package com.feria.tsuuki.controller;

import com.feria.tsuuki.models.category.CategoryRequest;
import com.feria.tsuuki.models.category.CategoryResponse;
import com.feria.tsuuki.service.implementation.CategoryServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImp categoryServiceImp;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllAvailable(){
        List<CategoryResponse> categories = categoryServiceImp.findAllAvailable();
        return new ResponseEntity<>(categories, HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(CategoryRequest categoryRequest){

        return null;
    }
}
