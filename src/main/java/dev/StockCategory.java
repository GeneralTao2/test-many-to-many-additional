package dev;

import lombok.AllArgsConstructor;
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
@AssociationOverrides({
        @AssociationOverride(name = "pk.stock",
                joinColumns = @JoinColumn(name = "STOCK_ID")),
        @AssociationOverride(name = "pk.category",
                joinColumns = @JoinColumn(name = "CATEGORY_ID")) })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockCategory implements java.io.Serializable {

    @EmbeddedId
    private StockCategoryId pk = new StockCategoryId();

    @Temporal(TemporalType.DATE)
    private Date createdDate;

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