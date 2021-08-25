package com.example.servingwebcontent;

public class Math {
    public Double calculate(Double num1, Double num2, EnumOperations operation){
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
}
