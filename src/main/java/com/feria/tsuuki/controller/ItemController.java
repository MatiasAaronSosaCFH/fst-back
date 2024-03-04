package com.feria.tsuuki.controller;

import com.feria.tsuuki.service.implementation.ItemServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemServiceImp itemServiceImp;
}
