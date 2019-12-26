package com.utils;

//负责做计算的类
public class Computer {
    private double num1;
    private double num2;
    private String calc;

    public Computer(double n1, double n2, String cal) {
        this.num1 = n1;
        this.num2 = n2;
        this.calc = cal;
    }


    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getCalc() {
        return calc;
    }

    public void setCalc(String calc) {
        this.calc = calc;
    }

    public double getResult() {
        switch (this.calc) {
            case "-":
                setResult(this.num1 - this.num2);
                break;
            case "+":
                setResult(this.num1 + this.num2);
                break;
            case "*":
                setResult(this.num1 * this.num2);
                break;
            case "/":
                setResult(this.num1 / this.num2);
                break;
        }
        return this.result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    private double result;
}
