package com.feria.tsuuki.service.implementation;

import com.feria.tsuuki.repository.TicketRepository;
import com.feria.tsuuki.service.abstraction.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImp implements TicketService {

    private final TicketRepository ticketRepository;

}
