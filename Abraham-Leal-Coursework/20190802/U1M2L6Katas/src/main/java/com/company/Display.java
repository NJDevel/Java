package com.company;

public class Display extends ComputerPart {

    private ComputerPart computerPart;
    private float sceenSize;
    private String graphicsCard;

    public Display(){

    }

    public ComputerPart getComputerPart() {
        return computerPart;
    }

    public void setComputerPart(ComputerPart computerPart) {
        this.computerPart = computerPart;
    }

    public float getSceenSize() {
        return sceenSize;
    }

    public void setSceenSize(float sceenSize) {
        this.sceenSize = sceenSize;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }
}
