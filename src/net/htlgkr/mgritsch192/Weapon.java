package net.htlgkr.mgritsch192;

import java.util.Objects;

public class Weapon {

    private final String name;
    private final CombatType combatType;
    private final DamageType damageType;
    private final int damage;
    private final int speed;
    private final int minStrength;
    private int value;

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int minStrength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.minStrength = minStrength;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public CombatType getCombatType() {
        return this.combatType;
    }

    public DamageType getDamageType() {
        return this.damageType;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getMinStrength() {
        return this.minStrength;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.combatType);
        hash = 97 * hash + Objects.hashCode(this.damageType);
        hash = 97 * hash + this.damage;
        hash = 97 * hash + this.speed;
        hash = 97 * hash + this.minStrength;
        hash = 97 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Weapon other = (Weapon) obj;
        if (this.damage != other.damage) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        if (this.minStrength != other.minStrength) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.combatType != other.combatType) {
            return false;
        }
        if (this.damageType != other.damageType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", combatType=" + combatType + ", damageType=" + damageType + ", damage=" + damage + ", speed=" + speed + ", minStrength=" + minStrength + ", value=" + value + '}';
    }

}
