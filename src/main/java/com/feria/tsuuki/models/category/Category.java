package com.feria.tsuuki.models.category;

import java.util.Date;
import java.util.List;

import com.feria.tsuuki.models.product.Product;
import com.feria.tsuuki.models.subcategory.SubCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Table(name = "category")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> products;
    @Column(name = "name")
    private String name;
    @Column(name = "is_present")
    private Boolean isPresent = true;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "update_at")
    private Date updateAt;
    @OneToMany(fetch = FetchType.EAGER)
    private List<SubCategory> subcategories;

}
