package com.feria.tsuuki.models.item;

import com.feria.tsuuki.models.product.Product;
import com.feria.tsuuki.models.ticket.Ticket;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @Column(name = "mount")
    private Integer mount;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;
}
