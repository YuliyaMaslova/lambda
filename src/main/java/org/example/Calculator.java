package org.example;

import java.util.function.*;

public class Calculator {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);
//        При вызове метода divide ошибка возникает по причине математической ошибки: делить на ноль нельзя!
//        Реализация исправления данной ошибки представлена в коде
        calc.println.accept(c);
        int d = calc.pow.apply(2);
        calc.println.accept(d);
        int e = calc.abs.apply(3);
        calc.println.accept(e);
        int f = calc.multiply.apply(8, 9);
        calc.println.accept(f);
        boolean g = calc.isPositive.test(3);
        calc.println.accept(g);
    }

    public static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : Integer.MAX_VALUE;

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Object> println = System.out::println;
}