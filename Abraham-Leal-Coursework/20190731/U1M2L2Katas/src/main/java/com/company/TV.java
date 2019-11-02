package com.company;

public class TV {

    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
    private int volume;
    private boolean powered;

    public TV (String manufacturerIn, String modelIn, int screenSizeIn, String channelIn, int volumeIn, boolean poweredIn) {

        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.screenSize = screenSizeIn;
        this.channel = channelIn;
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

    public int getScreenSize() {
        return this.screenSize;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isPowered() {
        return this.powered;
    }
}
