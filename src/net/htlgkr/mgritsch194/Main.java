/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch194;

import java.util.stream.IntStream;

/**
 *
 * @author maxim
 */
public class Main {

    public static void main(String[] args) {
        final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(i -> i % 2 != 0).map(i -> i * i).reduce((a, b) -> a + b).getAsInt();
        System.out.println(result);
    }
}
