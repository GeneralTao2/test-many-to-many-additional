package dev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category", catalog = "mkyongdb")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    private Integer id;

    private String name;

    @Column(name = "[DESC]")
    private String desc;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.category")
    private Set<StockCategory> stockCategories = new HashSet<StockCategory>(0);

}