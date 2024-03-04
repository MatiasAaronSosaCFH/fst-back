package com.feria.tsuuki.models.ticket;

import java.util.List;

public record TicketRequest(Long id,
                            String user,
                            List<TicketResponse> tickets) {
}
