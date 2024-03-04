package com.feria.tsuuki.models.subcategory;

import java.sql.Date;
import java.util.List;

import com.feria.tsuuki.models.category.Category;
import com.feria.tsuuki.models.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Table(name = "sub_categories")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "category_id")
    private Category category;
    @Column(name = "name")
    private String name;
    @Column(name = "is_present")
    private Boolean isPresent;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "update_at")
    private Date updateAt;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> products;
    
}
