package ru.artem.lab4;

import ru.artem.util.Fraction;

public class Application {
    public static void main(String[] args) {
        Fraction firstFraction = new Fraction("3/6");
        Fraction secondFraction = new Fraction("-3/4");
        System.out.println(firstFraction);
        System.out.println(secondFraction);
        System.out.println();
        System.out.println(firstFraction + " + " + secondFraction + " = " + firstFraction.add(secondFraction));
        System.out.println(firstFraction + " - " + secondFraction + " = " + firstFraction.subtract(secondFraction));
        System.out.println(firstFraction + " * " + secondFraction + " = " + firstFraction.multiply(secondFraction));
        System.out.println(firstFraction + " / " + secondFraction + " = " + firstFraction.divide(secondFraction));
        System.out.println(firstFraction + " ** 2 = " + firstFraction.square());
        System.out.println(secondFraction + " ** 2 = " + secondFraction.square());
        System.out.println("1 / " + secondFraction + " = " + secondFraction.inversed());
        System.out.println("-(" + secondFraction + ") = " + secondFraction.negate());
        System.out.println(firstFraction + " == " + secondFraction + " := " + firstFraction.equals(secondFraction));
        System.out.println(firstFraction + " == " + new Fraction("1/2") + " := " + firstFraction.equals(new Fraction("1/2")));
        System.out.println(firstFraction + " > " + secondFraction + " := " + (firstFraction.compareTo(secondFraction) > 0));
        System.out.println(secondFraction + " > " + firstFraction + " := " + (firstFraction.compareTo(secondFraction) > 0));
    }
}
