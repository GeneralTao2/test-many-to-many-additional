package dev;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category", catalog = "mkyongdb")
@Getter
@Setter
@NoArgsConstructor
public class Category implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    private Integer categoryId;
    @Column(name = "NAME", nullable = false, length = 10)
    private String name;
    @Column(name = "[DESC]", nullable = false)
    private String desc;
    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.category")
    private Set<StockCategory> stockCategories = new HashSet<StockCategory>(0);*/

    public Category(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

   /* public Category(String name, String desc, Set<StockCategory> stockCategories) {
        this.name = name;
        this.desc = desc;
        this.stockCategories = stockCategories;
    }*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId.equals(category.categoryId) && Objects.equals(name, category.name) && Objects.equals(desc, category.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }
}