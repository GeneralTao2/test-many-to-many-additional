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

            Category category1 = new Category("CONSUMER1", "CONSUMER COMPANY1");
            categoryRepository.save(category1);

            Category category2 = new Category("CONSUMER2", "CONSUMER COMPANY2");
            categoryRepository.save(category2);

            Category category3 = new Category("CONSUMER2", "CONSUMER COMPANY2");
            categoryRepository.save(category3);

            StockCategory stockCategory1 = new StockCategory();
            stockCategory1.setStock(stock);
            stockCategory1.setCategory(category1);
            stockCategory1.setCreatedDate(new Date());
            stockCategory1.setCreatedBy("system");

            StockCategory stockCategory2 = new StockCategory();
            stockCategory2.setStock(stock);
            stockCategory2.setCategory(category2);
            stockCategory2.setCreatedDate(new Date());
            stockCategory2.setCreatedBy("system");

            StockCategory stockCategory3 = new StockCategory();
            stockCategory3.setStock(stock);
            stockCategory3.setCategory(category3);
            stockCategory3.setCreatedDate(new Date());
            stockCategory3.setCreatedBy("system");

            // can add trough stockCategoryRepository
            stockCategoryRepository.save(stockCategory1);
            stockCategoryRepository.save(stockCategory2);
            stockCategoryRepository.save(stockCategory3);

            // can delete trough stockCategoryRepository
            stockCategoryRepository.delete(stockCategory1);

            // can show trough stockRepository
            Stock stock1 = stockRepository.getStockByStockCode(stockCode).get();
            System.out.println(stock1.getStockCategories());


            // can add trough stockRepository but questionable
            //stock.getStockCategories().add(stockCategory1);
            //stock.getStockCategories().add(stockCategory2);
            //stockRepository.save(stock);

            // cannot delete stockRepository - problem, but we have stockCategoryRepository
            //stock.getStockCategories().remove(stockCategory1);
            //stockRepository.save(stock);
        };
    }
}
