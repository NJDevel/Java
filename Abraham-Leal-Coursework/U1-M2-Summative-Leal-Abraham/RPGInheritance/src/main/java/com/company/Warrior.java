package com.company;

public class Warrior extends PlayableCharacter {

    private int shieldStrength;

    public Warrior(){
        this.strength = 75;
        this.health = 100;
        this.stamina = 100;
        this.speed = 50;
        this.attackPower = 10;
        this.shieldStrength = 100;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public void decreaseShieldStrength(int shieldStrengthLost){
        this.shieldStrength = this.shieldStrength - shieldStrengthLost;
    }
}
