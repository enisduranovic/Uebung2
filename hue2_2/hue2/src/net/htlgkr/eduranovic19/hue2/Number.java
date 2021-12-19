package net.htlgkr.eduranovic19.hue2;

public class Number {

    private double a, b;

    Number(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Number() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "a: " + a + " b: " + b;
    }

}
