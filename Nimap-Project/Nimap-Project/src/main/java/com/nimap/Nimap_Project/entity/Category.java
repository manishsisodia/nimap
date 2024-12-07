package com.nimap.Nimap_Project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    @Id
    @JsonProperty("category_id")
    private String category_id;

    @JsonProperty("category_name")
    private String category_name;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @JsonProperty("modified_by")
    private String modified_by;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "uni_product")
    private List<Product> product;

    @Override
    public String toString() {
        return "Category{" +
                "category_Id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", modified_by='" + modified_by + '\'' +
                '}';
    }

}
