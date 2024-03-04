package com.feria.tsuuki.controller;

import com.feria.tsuuki.service.implementation.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImp productServiceImp;
}
