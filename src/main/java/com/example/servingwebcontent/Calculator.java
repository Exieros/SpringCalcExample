package com.example.servingwebcontent;

import com.example.servingwebcontent.enums.EnumConvertOperations;
import com.example.servingwebcontent.enums.EnumMathOperations;

public class Calculator {
    public Double math(Double num1, Double num2, EnumMathOperations operation){
        switch (operation)
        {
            case MULTIPLICATION:
                return num1 * num2;
            case DIVISION:
                return num1 / num2;
            case ADDITION:
                return num1 + num2;
            case SUBTRACTION:
                return num1 - num2;
            default:
                return new Double(0);
        }
    }

    public String convert(Double num1, EnumConvertOperations operation){
        switch (operation)
        {
            case TOBINARY:
                return Long.toBinaryString(Double.doubleToRawLongBits(num1));
            default:
                return "";
        }
    }
}
