/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htgkr.mgritsch19;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author maxim
 */
public class Main {

    public static void main(String[] args) {
        List<Weapon> list = new LinkedList<>();

        list.sort((w1, w2) -> Integer.compare(w1.getDamage(), w2.getDamage()));

        list.sort((w1, w2) -> {
            if (w1.getCombatType().compareTo(w2.getCombatType()) != 0) {
                return w1.getCombatType().compareTo(w2.getCombatType());
            } else if (w1.getDamageType().compareTo(w2.getDamageType()) != 0) {
                return w1.getDamageType().compareTo(w2.getDamageType());
            } else {
                return w1.getName().compareTo(w2.getName());
            }
        });

        try {
            list = Files.lines(new File("weapons.csv").toPath())
                    .skip(1)
                    .map(s -> s.split(";"))
                    .map(s -> new Weapon(
                    s[0],
                    CombatType.valueOf(s[1]),
                    DamageType.valueOf(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]),
                    Integer.parseInt(s[5]),
                    Integer.parseInt(s[6])
            ))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Function<Double, Integer> f = x -> x.intValue();
        System.out.println("Function:       " + f.apply(47.11));
        BinaryOperator<Integer> m = (x, y) -> x % y;
        System.out.println("BinaryOperator: " + m.apply(5, 2));
        Supplier<Integer> s = () -> (int) (Math.random() * 10);
        System.out.println("Supplier:       " + s.get());
        Predicate<Integer> p = x -> x < 10;
        System.out.println("Predicate:      " + p.test(5));

        Consumer c = System.out::println;
        c.accept("hello");

        Printable printable = w -> System.out.println(w.getName() + " [" + w.getDamageType() + " = " + w.getDamage() + "]");
        printable.print(list.get(5));
    }
}
