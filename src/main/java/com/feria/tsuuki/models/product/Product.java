package com.feria.tsuuki.models.product;

import java.sql.Date;
import java.util.List;

import com.feria.tsuuki.models.image.Image;
import com.feria.tsuuki.models.item.Item;
import com.feria.tsuuki.models.subcategory.SubCategory;
import com.feria.tsuuki.models.category.Category;
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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    private SubCategory subCategory;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "is_present")
    private Boolean isPresent;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "update_at")
    private Date updateAt;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Image> images;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Item> items;

}
