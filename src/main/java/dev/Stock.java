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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", catalog = "mkyongdb", uniqueConstraints = {
        @UniqueConstraint(columnNames = "STOCK_NAME"),
        @UniqueConstraint(columnNames = "STOCK_CODE") })
@Getter
@Setter
@NoArgsConstructor
public class Stock implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "STOCK_ID")
    private Integer stockId;
    @Column(name = "STOCK_CODE")
    private String stockCode;
    @Column(name = "STOCK_NAME")
    private String stockName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.stock", cascade=CascadeType.ALL)
    private Set<StockCategory> stockCategories = new HashSet<StockCategory>(0);


    public Stock(String stockCode, String stockName) {
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    public Stock(String stockCode, String stockName,
                 Set<StockCategory> stockCategories) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockCategories = stockCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return stockId.equals(stock.stockId) && Objects.equals(stockCode, stock.stockCode) && Objects.equals(stockName, stock.stockName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId);
    }
}
