package com.example.servingwebcontent;

import com.example.servingwebcontent.enums.EnumMathOperations;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calc = new Calculator();

    @Test
    public void testAddition() throws Exception {
        Assert.assertEquals(new Double(5), calc.math(2d,3d, EnumMathOperations.ADDITION));
        Assert.assertEquals(new Double(0), calc.math(0d,0d, EnumMathOperations.ADDITION));
        Assert.assertEquals(new Double(2000000000), calc.math(1000000000d,1000000000d, EnumMathOperations.ADDITION));
        Assert.assertEquals(new Double(3), calc.math(1.00000001,1.99999999, EnumMathOperations.ADDITION));
        Assert.assertEquals(new Double(100002), calc.math(1.5,100000.5, EnumMathOperations.ADDITION));
    }

    @Test
    public void testDivision() throws Exception {
        Assert.assertEquals(new Double(2.5), calc.math(5d,2d, EnumMathOperations.DIVISION));
        Assert.assertEquals(new Double(0.3333333333333333), calc.math(1d,3d, EnumMathOperations.DIVISION));
        Assert.assertEquals(new Double(0), calc.math(100d,0d, EnumMathOperations.DIVISION));
    }

    @Test
    public void testMultiplication() throws Exception {
        double epsilon = 0.000001d;
        Assert.assertEquals(new Double(10), calc.math(5d,2d, EnumMathOperations.MULTIPLICATION));
        Assert.assertEquals(new Double(0.9), calc.math(0.3d,3d, EnumMathOperations.MULTIPLICATION), epsilon);
        Assert.assertEquals(new Double(10), calc.math(-5d,-2d, EnumMathOperations.MULTIPLICATION));
    }

    @Test
    public void testSubtraction() throws Exception {
        Assert.assertEquals(new Double(3), calc.math(5d,2d, EnumMathOperations.SUBTRACTION));
        Assert.assertEquals(new Double(-100), calc.math(0d,100d, EnumMathOperations.SUBTRACTION));
        Assert.assertEquals(new Double(0.05), calc.math(0.1d,0.05d, EnumMathOperations.SUBTRACTION));
    }
}
