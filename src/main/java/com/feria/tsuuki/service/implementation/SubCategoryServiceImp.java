package com.feria.tsuuki.service.implementation;

import com.feria.tsuuki.repository.SubCategoryRepository;
import com.feria.tsuuki.service.abstraction.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImp implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
}
