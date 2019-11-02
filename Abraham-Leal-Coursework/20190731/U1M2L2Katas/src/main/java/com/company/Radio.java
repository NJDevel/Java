package com.company;

public class Radio {

    private String manufacturer;
    private String model;
    private int numSpeakers;
    private String station;
    private int volume;
    private boolean powered;

    public Radio(String manufacturerIn, String modelIn, int numSpeakerIn, String stationIn, int volumeIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.numSpeakers = numSpeakerIn;
        this.station = stationIn;
        this.volume = volumeIn;
        this.powered = poweredIn;
    }

    public void togglePower() {

        if (this.powered == true) {
            this.powered = false;
        } else
            this.powered = true;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getNumSpeakers() {
        return this.numSpeakers;
    }

    public String getStation() {
        return this.station;
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isPowered() {
        return this.powered;
    }
}
