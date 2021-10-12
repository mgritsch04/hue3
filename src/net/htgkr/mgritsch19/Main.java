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

        list = Main.sortDamage(list);
        Printable printable = l -> {
            for (Weapon w : l) {
                System.out.println(w.getName() + " [" + w.getDamageType() + " = " + w.getDamage() + "]");
            }
        };

        printable.print(list);

        System.out.println("");
        Printable printTable = l -> {
            int index = 0;
            for (int i = 0; i < 4; i++) {
                System.out.println("+--------------------------------+--------------------------------+--------------------------------+--------------------------------+");
                for (int j = index; j < index + 4; j++) {
                    System.out.print("|");
                    System.out.print(l.get(j).getName() + " [" + l.get(j).getDamageType() + " = " + l.get(j).getDamage() + "]");
                    String s = String.valueOf(l.get(j).getDamage());
                    int length = l.get(j).getName().length() + l.get(j).getDamageType().toString().length() + 6 + s.length();
                    for (int k = length; k < 32; k++) {
                        System.out.print(" ");
                    }
                }
                index += 4;
                System.out.print("|");
                System.out.println("");
            }

        };

        printTable.print(list);

    }

    public static List<Weapon> sortDamage(List<Weapon> list) {
        list.sort((w1, w2) -> Integer.compare(w2.getDamage(), w1.getDamage()));
        return list;
    }

    public static List<Weapon> sortAlpha(List<Weapon> list) {
        list.sort((w1, w2) -> {
            if (w1.getCombatType().compareTo(w2.getCombatType()) != 0) {
                return w1.getCombatType().compareTo(w2.getCombatType());
            } else if (w1.getDamageType().compareTo(w2.getDamageType()) != 0) {
                return w1.getDamageType().compareTo(w2.getDamageType());
            } else {
                return w1.getName().compareTo(w2.getName());
            }
        });
        return list;
    }
}
