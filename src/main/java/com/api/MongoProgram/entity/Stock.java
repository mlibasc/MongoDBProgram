package com.api.MongoProgram.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "stock")
public class Stock {
    @Id
    private String id;
    private String symbol;
    private BigDecimal ask;
    private BigDecimal bid;

    public Stock(){
        this.symbol = "DEFAULT";
        this.ask = new BigDecimal(0);
        this.bid = new BigDecimal(0);
    }

    public Stock(String symbol, BigDecimal ask, BigDecimal bid){
        this.symbol = symbol;
        this.ask = ask;
        this.bid = bid;
    }

    public Stock(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public String toString(){
        return "Symbol: " + symbol + "Ask: " + ask + "Big: " + bid;
    }
}
