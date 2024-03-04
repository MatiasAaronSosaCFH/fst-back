package com.feria.tsuuki.controller;

import com.feria.tsuuki.service.implementation.SubCategoryServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sub_categories")
public class SubCategoryController {

    private final SubCategoryServiceImp subCategoryServiceImp;


}
