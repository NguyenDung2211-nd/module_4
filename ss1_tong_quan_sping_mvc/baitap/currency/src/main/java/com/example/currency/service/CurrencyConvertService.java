package com.example.currency.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConvertService {
    public double convert(double rate, double usd){
        return usd * rate;
    }
}
