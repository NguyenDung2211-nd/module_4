package com.example.ung_dung_may_tinh.controller;

import com.example.ung_dung_may_tinh.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/operator")
    public String calculate(@RequestParam(name = "number1", required = false) String number1Str,
                            @RequestParam(name = "number2", required = false) String number2Str,
                            @RequestParam(name = "operator", required = false) String operator,
                            Model model) {
        try {
            if (number1Str == null || number2Str == null || operator == null || operator.isEmpty()) {
                model.addAttribute("", "Vui lòng nhập đầy đủ các số và phép toán.");
                return "calculator";
            }

            float number1 = Float.parseFloat(number1Str);
            float number2 = Float.parseFloat(number2Str);

            float result = calculatorService.calculator(number1, number2, operator);
            model.addAttribute("result", result);
            return "calculator";
        }catch(NumberFormatException e){
            model.addAttribute("error", "Vui lòng chỉ nhập số!");
            return "calculator";
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "calculator";
    }
}


