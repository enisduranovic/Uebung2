package net.htlgkr.eduranovic19.hue2;

import java.util.Scanner;

public class CalculatorMain {

    static RationalCalculator r;
    static VectorCalculator v;
    static ComplexCalculator c;

    public static void initializeRationalCalculator() {
        CalculationOperation add = (a, b) -> new Number(a.getA() * b.getB() + a.getB() * b.getA(), a.getB() * b.getB());
        CalculationOperation sub = (a, b) -> new Number(a.getA() * b.getB() - a.getB() * b.getA(), a.getB() * b.getB());
        CalculationOperation mul = (a, b) -> new Number(a.getA() * b.getA(), a.getB() * b.getB());
        CalculationOperation div = (a, b) -> new Number(a.getA() * b.getB(), a.getB() * b.getA());
        r = new RationalCalculator(add, sub, mul, div);
    }

    public static void initializeVectorCalculator() {
        CalculationOperation add = (a, b) -> new Number(a.getA() + b.getA(), a.getB() + b.getB());
        CalculationOperation sub = (a, b) -> new Number(a.getA() - b.getA(), a.getB() - b.getB());
        CalculationOperation mul = (a, b) -> new Number(a.getA() * b.getA(), a.getB() * b.getB());
        CalculationOperation div = (a, b) -> new Number(a.getA() / b.getA(), a.getB() / b.getB());
        v = new VectorCalculator(add, sub, mul, div);
    }

    public static void initializeComplexCalculator() {
        CalculationOperation add = (a, b) -> new Number(a.getA() + b.getA(), a.getB() + b.getB());
        CalculationOperation sub = (a, b) -> new Number(a.getA() - b.getA(), a.getB() - b.getB());
        CalculationOperation mul = (a, b) -> new Number(a.getA() * b.getA() - a.getB() * b.getB(), a.getA() * b.getB() + a.getB() * b.getA());
        CalculationOperation div = (a, b) -> new Number((a.getA() * b.getA() + a.getB() * b.getB()) / (Math.pow(b.getA(), 2) + Math.pow(b.getB(), 2)), (a.getB() * b.getA() - a.getA() * b.getB()) / (Math.pow(b.getA(), 2)));
        c = new ComplexCalculator(add, sub, mul, div);
    }

    public static void op() {
        System.out.println("Choose Calculator: ");
        System.out.println("1 - add");
        System.out.println("2 - substract");
        System.out.println("3 - multiply");
        System.out.println("4 - divide");
        System.out.println("5 - enter numbers again");
    }

    public static void main(String[] args) {
        Number erg;
        AbstractCalculator ac;
        initializeComplexCalculator();
        initializeRationalCalculator();
        initializeVectorCalculator();
        int eingMenu = 0;
        int eingOp = 0;
        Number a = new Number();
        Number b = new Number();
        Number z = new Number();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Choose Calculator: ");
            System.out.println("1 - Relational Calculator");
            System.out.println("2 - Vector Calculator");
            System.out.println("3 - Complex Calculator");
            System.out.println("4 - Exit program");
            eingMenu = Integer.parseInt(sc.nextLine());
            if (eingMenu == 1) {
                System.out.println("Enter number x a>");
                double rational1 = Double.parseDouble(sc.nextLine());
                a.setA(rational1);
                System.out.println("Enter number x b>");
                double rational2 = Double.parseDouble(sc.nextLine());
                a.setB(rational2);
                System.out.println("Enter number y a>");
                double rational3 = Double.parseDouble(sc.nextLine());
                b.setA(rational3);
                System.out.println("Enter number x a>");
                double rational4 = Double.parseDouble(sc.nextLine());
                b.setB(rational4);
                op();
                eingOp = Integer.parseInt(sc.nextLine());
                calculate(r, eingOp, a, b);
            } else if (eingMenu == 2) {
                System.out.println("Enter number x a> ");
                double vector1 = Double.parseDouble(sc.nextLine());
                a.setA(vector1);
                System.out.println("Enter number x b> ");
                double vector2 = Double.parseDouble(sc.nextLine());
                a.setB(vector2);
                System.out.println("Enter number y a> ");
                double vector3 = Double.parseDouble(sc.nextLine());
                b.setA(vector3);
                System.out.println("Enter number y b> ");
                double vector4 = Double.parseDouble(sc.nextLine());
                b.setB(vector4);

                op();
                eingOp = Integer.parseInt(sc.nextLine());
                calculate(v, eingOp, a, b);
            } else if (eingMenu == 3) {
                System.out.println("Enter number x a>");
                double complex1 = Double.parseDouble(sc.nextLine());
                a.setA(complex1);
                System.out.println("Enter number x b>");
                double complex2 = Double.parseDouble(sc.nextLine());
                a.setB(complex2);
                System.out.println("Enter number y a>");
                double complex3 = Double.parseDouble(sc.nextLine());
                b.setA(complex3);
                System.out.println("Enter number y b>");
                double complex4 = Double.parseDouble(sc.nextLine());
                b.setB(complex4);
                op();
                eingOp = Integer.parseInt(sc.nextLine());
                calculate(c, eingOp, a, b);
            } else if (eingMenu == 4) {
                break;
            } else {
                System.out.println("Geben Sie eine Zahl zwischen 1 und 4 ein! ");
                int var = 0;
                int var2 = 0;
                int var3 = 0;
                int var4 = 0;
                int var5 = 0;
                int var6 = 0;
                int var7 = 0;
                int var8 = 0;
                int var9 = 0;
            }
        } while (eingMenu < 4 && eingMenu != 4);
    }

    public static void calculate(AbstractCalculator ac, int eingOp, Number a, Number b) {
        Number erg = null;
        switch (eingOp) {
            case 1:
                erg = ac.add(a, b);
                System.out.println(erg.toString());
                break;
            case 2:
                erg = ac.substract(a, b);
                System.out.println(erg.toString());
                break;
            case 3:
                erg = ac.multiply(a, b);
                System.out.println(erg.toString());
                break;
            case 4:
                erg = ac.divide(a, b);
                System.out.println(erg.toString());
                break;
            default:
                System.out.println("Zahl zwischen 1 & 5 eingeben!");
                break;
        }
    }
}
