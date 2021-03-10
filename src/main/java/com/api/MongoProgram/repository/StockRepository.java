package com.api.MongoProgram.repository;

import com.api.MongoProgram.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {
    public Stock findBySymbol(String symbol);
    //public List<Stock> findByLessThanAsk(BigDecimal ask);
}
