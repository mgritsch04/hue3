/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mgritsch192;

import java.util.Arrays;

/**
 *
 * @author maxim
 */
public class Main {

    public static void main(String[] args) {
        Streams s = new Streams();

        System.out.println("average:");
        int[] numbers = {5, 10};
        System.out.println("Average 5 & 10 (7.5): " + s.average(numbers));
        System.out.println("");

        System.out.println("uppercase:");
        System.out.println(Arrays.stream(s.StringArr).toList());
        System.out.println(s.upperCase(s.StringArr));
        System.out.println("");

        System.out.println("findWeaponWithLowestDamage:");
        System.out.println(s.findWeaponWithLowestDamage(s.list).toString());
        System.out.println("");

        System.out.println("findWeaponWithHighestStrength");
        System.out.println(s.findWeaponWithHighestStrength(s.list).toString());
        System.out.println("");

        System.out.println("collectMissileWeapons:");
        System.out.println(s.collectMissileWeapons(s.list));
        System.out.println("");

        System.out.println("findWeaponWithLongstNKame:");
        System.out.println(s.findWeaponWithLongestName(s.list).toString());
        System.out.println("");

        System.out.println("toNameList:");
        System.out.println(s.toNameList(s.list));
        System.out.println("");

        System.out.println("toSpeedArray:");
        int[] a = s.toSpeedArray(s.list);
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println("");
        System.out.println("");

        System.out.println("sumUpValues:");
        System.out.println(s.sumUpValues(s.list));
        System.out.println("");

        System.out.println("sumUpHashCodes:");
        System.out.println(s.sumUpHashCodes(s.list));
        System.out.println("");

        System.out.println("removeDuplicates");
        System.out.println(s.removeDuplicates(s.list));
        System.out.println("");

        System.out.println("increaseValuesByTenPercent");
        System.out.println(s.list);
    }
}
