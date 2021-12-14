/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch193;

import java.util.function.Predicate;

/**
 *
 * @author maxim
 */
public class Main {

    public static void main(String[] args) {
        final Predicate<Integer> isEven = (n) -> n % 2 == 0;

        final Predicate<Integer> isPositive = (n) -> n > 0;

        final Predicate<String> isShortWord = (s) -> s.length() < 4;

        final Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);

        final Predicate<Integer> isPositiveAndUneven = (Predicate<Integer>) isPositive.and(isEven.negate());

        System.out.println(isEvenAndPositive.test(3));
        System.out.println(isPositive.test(1));
    }
}
