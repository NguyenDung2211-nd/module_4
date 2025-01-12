package com.example.ung_dung_may_tinh.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public float calculator(float number1, float number2, String operator) {
        float result = 0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 != 0) {
                    result = number1 / number2;
                }else{
                    throw new RuntimeException("Không thể chia cho 0.");
                }
                break;
            default:
                throw new RuntimeException("Phép toán không hợp lệ.");
        }
        return result;
    }
}
