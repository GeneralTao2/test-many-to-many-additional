package dev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
public class StockCategoryId implements java.io.Serializable {

    @ManyToOne
    private Stock stock;

    @ManyToOne
    private Category category;

    public int hashCode() {
        int result;
        result = (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

}