package com.feria.tsuuki.models.ticket;

import com.feria.tsuuki.models.item.Item;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user")
    private String user;
    @OneToMany
    private List<Item> items;
    @Temporal(TemporalType.DATE)
    @Column(name = "buy_date")
    private Date buyDate;

}
