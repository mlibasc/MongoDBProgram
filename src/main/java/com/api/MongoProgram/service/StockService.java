package com.api.MongoProgram.service;

import com.api.MongoProgram.entity.Stock;
import com.api.MongoProgram.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock create(String symbol, BigDecimal ask, BigDecimal bid){
        return stockRepository.save(new Stock(symbol, ask, bid));
    }

    public List<Stock> getAll(){
        return stockRepository.findAll();
    }

    public Stock getBySymbol(String symbol){
        return stockRepository.findBySymbol(symbol);
    }

    public Stock update(String symbol, BigDecimal ask, BigDecimal bid){
        Stock stock = stockRepository.findBySymbol(symbol);
        stock.setAsk(ask);
        stock.setBid(bid);
        return stockRepository.save(stock);
    }

    public void deleteAll(){
        stockRepository.deleteAll();
    }

    public void deleteStock(String symbol){
        Stock stock = stockRepository.findBySymbol(symbol);
        stockRepository.delete(stock);
    }
}
