package com.feria.tsuuki.service.implementation;

import com.feria.tsuuki.repository.ItemRepository;
import com.feria.tsuuki.service.abstraction.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImp implements ItemService {

    private final ItemRepository itemRepository;
}
