package com.company;

public class PlayableCharacter {

    protected String name;
    protected int strength;
    protected int health;
    protected int stamina;
    protected int speed;
    protected int attackPower;

    public PlayableCharacter(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void run(){}

    public void attack(){}

    public void heal(int healthRecovered){
        this.health = this.health + healthRecovered;
    }

    public void decreaseHealth(int healthLost){
        this.health = this.health - healthLost;
    }

    public void increaseStamina(int staminaGained){
        this.stamina = this.stamina + staminaGained;
    }

    public void decreaseStamina(int staminaLost){
        this.stamina = this.stamina - staminaLost;
    }



}
