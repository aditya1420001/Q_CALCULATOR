package com.crio.qcalc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class StandardCalculatorTest {
    private StandardCalculator standardCalculator;

    @BeforeEach
    void setup(){
        standardCalculator = new StandardCalculator();
    }

    @Test
    @DisplayName("Test Multiplication Overflow of Two Doubles")
    void testMultiplicationOverflowForDoubles(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class,new Executable(){
            @Override
            public void execute() throws Throwable {
                standardCalculator.multiply(Double.MAX_VALUE,Double.MAX_VALUE);
            }
        });

        Assertions.assertThrows(ArithmeticException.class, new Executable(){
            @Override
            public void execute() {
                standardCalculator.multiply(Double.MAX_VALUE,-2);
            }
        });

        Assertions.assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() {
                standardCalculator.multiply(Double.MAX_VALUE, 1);
            }
        });
    }
    @Test
    @DisplayName("Test Multiplication Overflow of Two Doubles in which One is Positive and Other is Negative")
    void testMultiplicationOverflowForDoublesOnePosOtherNeg(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class,new Executable(){
            @Override
            public void execute() throws Throwable{
                standardCalculator.multiply(-Double.MAX_VALUE,Double.MAX_VALUE);
            }
        });
    }

    @Test
    @DisplayName("Test Addition Overflow of Two Doubles")
    void testAdditionOverflowForDoubles(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class,new Executable(){
            @Override
            public void execute() throws Throwable{
                standardCalculator.add(Double.MAX_VALUE, Double.MAX_VALUE);
            }
        });
    }

    @Test
    @DisplayName("Test Subtraction Overflow of Two Doubles")
    void testSubtractionOverflowForDoubles(){
        //Assert
        Assertions.assertThrows(ArithmeticException.class,new Executable(){
            @Override
            public void execute() throws Throwable{
                standardCalculator.subtract(-Double.MAX_VALUE,Double.MAX_VALUE);
            }
        });

        Assertions.assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() {
                standardCalculator.subtract(-Double.MAX_VALUE, 0);
            } 
        });

        standardCalculator.subtract(Double.MIN_VALUE,100.0D);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(-100.0D, actualResult);
    }

    @Test
    @DisplayName("Test Addition of Two Doubles")
    void testAdditionOperationForDoubles(){
        standardCalculator.add(1.0,1.5);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(2.5, actualResult);
    }

    @Test
    @DisplayName("Test Substraction of Two Doubles")
    void testSubtractionOperationForDoubles(){
        standardCalculator.subtract(10.0,20.5);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(-10.5, actualResult);
    }

    @Test
    @DisplayName("Test Addition of Two Integers")
    void testAdditionOperation(){
        standardCalculator.add(1,1);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(2, actualResult);
    }

    @Test
    @DisplayName("Test Substraction of Two Integers")
    void testSubtractionOperation(){
        standardCalculator.subtract(1,1);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(0, actualResult);
    }

    @Test
    @DisplayName("Test Multiplication of Two Doubles")
    void testMultiplicationOperationForDoubles() {
        standardCalculator.multiply(1.2, 2.3);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(2.76, actualResult);
    }

    @Test
    @DisplayName("Test Multiplication of Two Integers")
    void testMultiplicationOperation() {
        standardCalculator.multiply(2, 3);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(6, actualResult);

        standardCalculator.multiply(3, 0);
        actualResult = standardCalculator.getResult();
        Assertions.assertEquals(0, actualResult);

        standardCalculator.multiply(-2, 4);
        actualResult = standardCalculator.getResult();
        Assertions.assertEquals(-8, actualResult);

        standardCalculator.multiply(-2, -4);
        actualResult = standardCalculator.getResult();
        Assertions.assertEquals(8, actualResult);

    }


    @Test
    @DisplayName("Test Division for Two Doubles")
    void testDivisionOperationForDoubles() {
        standardCalculator.divide(3.6, 2.0);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(1.8, actualResult);
        
        Assertions.assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() {
                standardCalculator.divide(5.0, 0);
            }
        });

    }

    @Test
    @DisplayName("Test Division of Two Integers")
    void testDivisionOperation() {
        standardCalculator.divide(6, 3);
        double actualResult = standardCalculator.getResult();
        Assertions.assertEquals(2, actualResult);

        standardCalculator.divide(3, 6);
        actualResult = standardCalculator.getResult();
        Assertions.assertEquals(0.5, actualResult);
    }

}
