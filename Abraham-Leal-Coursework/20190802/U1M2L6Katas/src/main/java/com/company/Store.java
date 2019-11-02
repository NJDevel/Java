package com.company;

public class Store {

    protected String name;
    protected String Address;
    protected float cashBalance;
    private Chips chips;
    private SodaPop sodaPop;
    private Chocolate chocolate;

    public Store(){

    }

    public void issueBill(){

    }

    public void issueReceipt(){

    }

    public void receivePayment(int cashIn){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public float getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(float cashBalance) {
        this.cashBalance = cashBalance;
    }
}
