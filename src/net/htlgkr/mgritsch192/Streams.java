package net.htlgkr.mgritsch192;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Streams {

    public int[] arr = new int[10000];
    public String[] StringArr = new String[10];
    public List<Weapon> list = new LinkedList<>();

    public Streams() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < 10; i++) {
            String randomString = "";
            for (int j = 0; j < 10; j++) {
                randomString += chars[(int) (Math.random() * chars.length)];

            }
            StringArr[i] = randomString;
        }

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
            Logger.getLogger(Streams.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().orElseThrow();
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(String::toUpperCase).toList();
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream().min(Comparator.comparing(Weapon::getDamage)).orElse(null);
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream().max(Comparator.comparing(Weapon::getMinStrength)).orElse(null);
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(weapon -> weapon.getDamageType().equals(DamageType.MISSILE)).collect(Collectors.toList());

    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return (Weapon) weapons.stream().max((o1, o2) -> {
            return o1.getName().length() - o2.getName().length();
        }).orElse(null);
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(Weapon::getName).collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        List<Integer> a = weapons.stream().map(Weapon::getSpeed).collect(Collectors.toList());
        int[] b = new int[a.size()];

        for (int i = 0; i < a.size(); i++) {
            b[i] = a.get(i);

        }
        return b;
    }

    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream().mapToInt(Weapon::getValue).sum();
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream().mapToInt(Weapon::hashCode).sum();
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().distinct().toList();
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream().forEach(weapon -> weapon.setValue((int) (weapon.getValue() * 1.1)));
    }
}
