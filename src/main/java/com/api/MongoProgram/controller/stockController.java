package com.api.MongoProgram.controller;

import com.api.MongoProgram.entity.Stock;
import com.api.MongoProgram.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class stockController {

    @Autowired
    private StockService stockService;


    @GetMapping("/create/{symbol}/{ask}/{bid}")
    public void create(@PathVariable("symbol") String symbol,
                         @PathVariable("ask") BigDecimal ask,
                         @PathVariable("bid") BigDecimal bid){
        Stock stock = stockService.create(symbol, ask, bid);
        //return stock.toString();
    }

    @GetMapping("/get/{symbol}")
    public Stock getStock(@PathVariable("symbol") String symbol){
        Stock stock = stockService.getBySymbol(symbol);
        return stock;
    }

    @GetMapping("/getAll")
    public List<Stock> getAll(){
        return stockService.getAll();
    }

    @GetMapping("/update/{symbol}/{ask}/{bid}")
    public void update(@PathVariable("symbol") String symbol,
                       @PathVariable("ask") BigDecimal ask,
                       @PathVariable("bid") BigDecimal bid){
        stockService.update(symbol, ask, bid);
    }

    @GetMapping("/delete/{symbol}")
    public String delete(@PathVariable("symbol") String symbol){
        stockService.deleteStock(symbol);
        return "deleted " + symbol;
    }

    @GetMapping("/deleteAll")
    public String deleteAll(){
        stockService.deleteAll();
        return "deleted all stocks";
    }
}
