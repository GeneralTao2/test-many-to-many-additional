package dev;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "stock_category", catalog = "mkyongdb")
@AssociationOverrides({
        @AssociationOverride(name = "pk.stock",
                joinColumns = @JoinColumn(name = "STOCK_ID")),
        @AssociationOverride(name = "pk.category",
                joinColumns = @JoinColumn(name = "CATEGORY_ID")) })
@Getter
@Setter
@NoArgsConstructor
public class StockCategory implements java.io.Serializable {

    @EmbeddedId
    private StockCategoryId pk = new StockCategoryId();
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 10)
    private Date createdDate;
    @Column(name = "CREATED_BY", nullable = false, length = 10)
    private String createdBy;


    @Transient
    public Stock getStock() {
        return getPk().getStock();
    }

    public void setStock(Stock stock) {
        getPk().setStock(stock);
    }

    @Transient
    public Category getCategory() {
        return getPk().getCategory();
    }

    public void setCategory(Category category) {
        getPk().setCategory(category);
    }


    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        StockCategory that = (StockCategory) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}