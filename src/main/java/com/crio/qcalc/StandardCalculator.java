package com.crio.qcalc;

public class StandardCalculator {

    protected double result;

    public static void getVersion(){
        System.out.println("Standard Calculator 1.0");
    }
    public final void add(int num1, int num2) {
        this.add((double) num1, (double) num2);
    } 

    public final void add(double num1, double num2) {
        double result = num1 + num2;
        if ((result == Double.MAX_VALUE) 
            || (result == Double.POSITIVE_INFINITY)) {
            throw new ArithmeticException("Double overflow");
        }
        this.result = result;
    }

    public final void subtract(int num1, int num2) {
        this.subtract((double)num1, (double)num2);
    } 

    public final void subtract(double num1, double num2) {
        double result = num1 - num2;
        if ((result == -Double.MAX_VALUE) 
            || (result == Double.NEGATIVE_INFINITY)) {
                throw new ArithmeticException("Double overflow");
            }
            
        this.result = result;
    }

    public final void multiply(int num1, int num2) {
        this.multiply((double)num1, (double)num2);
    } 

    public final void multiply(double num1, double num2) {
        double result = num1 * num2;
        if ((result == Double.POSITIVE_INFINITY) 
        || (result == Double.NEGATIVE_INFINITY)
        || (result == Double.MAX_VALUE)) {
            throw new ArithmeticException("Double overFlow");
        }
        this.result = result;
    }

    public final void divide(int num1, int num2) { 
        this.divide((double)num1, (double)num2);
    }

    public final void divide(double num1, double num2) {
        if (num2 == 0.0D) {
            throw new ArithmeticException("Divide By Zero");
        }
        this.result = num1/num2;
    }

    public final void setResult(int value) {
        if (value != 0) {
            return;
        }
        this.result = value;
    }

    public double getResult() {
        return this.result;
    }

    public final void clearResult() {
        this.result = 0;
    }

    public void printResult() {
        System.out.println("Standard Calculator Result:" + this.result);
    }
}
