package net.htlgkr.eduranovic19.hue2;

public class VectorCalculator extends AbstractCalculator {

    public VectorCalculator(CalculationOperation add, CalculationOperation substract, CalculationOperation multiply, CalculationOperation divide) {
        super(add, substract, multiply, divide);
    }

    @Override
    public Number add(Number a, Number b) {
        return super.add.calc(a, b);
    }

    @Override
    public Number substract(Number a, Number b) {
        return super.substract.calc(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return super.multiply.calc(a, b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return super.divide.calc(a, b);
    }

}
