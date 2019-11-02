package com.company;

public class Kitchen extends Room {

    private Sink sink;
    private Room room;
    private Stove stove;
    private Oven oven;
    private Refridgerator refridgerator;

    public Kitchen(){

    }

    public Sink getSink() {
        return sink;
    }

    public void setSink(Sink sink) {
        this.sink = sink;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Stove getStove() {
        return stove;
    }

    public void setStove(Stove stove) {
        this.stove = stove;
    }

    public Oven getOven() {
        return oven;
    }

    public void setOven(Oven oven) {
        this.oven = oven;
    }

    public Refridgerator getRefridgerator() {
        return refridgerator;
    }

    public void setRefridgerator(Refridgerator refridgerator) {
        this.refridgerator = refridgerator;
    }
}
