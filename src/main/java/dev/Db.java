package dev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Db {
    @Bean
    CommandLineRunner initDB(
            CategoryRepository categoryRepository,
            StockRepository stockRepository,
            StockCategoryRepository stockCategoryRepository
    ) {
        return args -> {
            Stock stock = new Stock();
            String stockCode = "7052";
            stock.setStockCode(stockCode);
            stock.setStockName("PADINI");

            stockRepository.save(stock);
            stock = stockRepository.getStockByStockCode(stockCode).get();

            Category category1 = new Category(1,"CONSUMER1", "CONSUMER COMPANY1", null);
            categoryRepository.save(category1);

            Category category2 = new Category(2,"CONSUMER2", "CONSUMER COMPANY2", null);
            categoryRepository.save(category2);

            StockCategory stockCategory1 = new StockCategory();
            stockCategory1.setStock(stock);
            stockCategory1.setCategory(category1);
            stockCategory1.setCreatedDate(new Date()); //extra column
            stockCategory1.setCreatedBy("system"); //extra column

            StockCategory stockCategory2 = new StockCategory();
            stockCategory2.setStock(stock);
            stockCategory2.setCategory(category2);
            stockCategory2.setCreatedDate(new Date()); //extra column
            stockCategory2.setCreatedBy("system"); //extra column

            stock.getStockCategories().add(stockCategory1);
            stock.getStockCategories().add(stockCategory2);

            stockRepository.save(stock);
            /*stock.getStockCategories().remove(stockCategory1);
            stockRepository.save(stock);*/
        };
    }
}
