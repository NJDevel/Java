package com.company;

public class VendingMachine extends Store {

    protected int numOfOptions;
    protected int numOfInventory;
    protected boolean isEmpty;
    private Mints mints;
    private Gum gum;
    private Popcorn popcorn;

    public VendingMachine(){

    }

    public void issueSnack(){

    }

    public int getNumOfOptions() {
        return numOfOptions;
    }

    public void setNumOfOptions(int numOfOptions) {
        this.numOfOptions = numOfOptions;
    }

    public int getNumOfInventory() {
        return numOfInventory;
    }

    public void setNumOfInventory(int numOfInventory) {
        this.numOfInventory = numOfInventory;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Mints getMints() {
        return mints;
    }

    public void setMints(Mints mints) {
        this.mints = mints;
    }

    public Gum getGum() {
        return gum;
    }

    public void setGum(Gum gum) {
        this.gum = gum;
    }

    public Popcorn getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(Popcorn popcorn) {
        this.popcorn = popcorn;
    }
}
