package dev;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository  extends JpaRepository<Stock , Long> {
    Optional<Stock> getStockByStockCode(String stockCode);
}
