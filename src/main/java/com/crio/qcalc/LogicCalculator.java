package com.crio.qcalc;

public class LogicCalculator extends StandardCalculator{

    public static void getVersion(){
        System.out.println("Logic Calculator 1.0");
    }
    public void AND(int num1, int num2){
        int result = num1 & num2;
        this.result = result;
    }
    public void OR(int num1, int num2){
        int result = num2 | num2;
        this.result = result;
    }
    public void XOR(int num1, int num2){
        int result = num1 ^ num2;
        this.result = result;
    }
    public void NOT(int num1){
        int result = ~num1;
        this.result = result;
    }
    @Override
    public void printResult(){
        System.out.println("Logic Calculator Result:"+ result );
    }
}
