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
        final Predicate<Integer> isEven = (t) -> {
            return (t % 2 == 0);
        };
        System.out.println("Die Zahl 6 ist Gerade: " + isEven);

    }
}
