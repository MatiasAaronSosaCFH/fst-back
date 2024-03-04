package com.feria.tsuuki.controller;

import com.feria.tsuuki.service.implementation.TicketServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private final TicketServiceImp ticketServiceImp;
}

