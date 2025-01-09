package com.example.currency.controller;

import com.example.currency.service.CurrencyConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/converts")
public class CurrencyConvertController {

    @Autowired
    private CurrencyConvertService convertService;

    @GetMapping("")
    public String index(){
        return "currency";
    }

    @PostMapping("")
    public String convert(@RequestParam("rate") String rateStr,
                          @RequestParam("usd") String usdStr, Model model) {
        try {
            double rate = Double.parseDouble(rateStr);
            double usd = Double.parseDouble(usdStr);

            if (rate <= 0 || usd < 0) {
                model.addAttribute("error", "Tỉ giá và số lượng USD phải là số dương.");
                return "currency";
            }

            double vnd = convertService.convert(rate, usd);
            model.addAttribute("vnd", vnd);
            model.addAttribute("usd", usd);
            return "currency";

        } catch (NumberFormatException e) {
            model.addAttribute("error", "Vui lòng nhập tỉ giá và số lượng USD là số hợp lệ.");
            return "currency";
        }
    }
}
