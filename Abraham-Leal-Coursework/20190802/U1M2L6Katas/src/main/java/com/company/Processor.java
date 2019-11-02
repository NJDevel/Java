package com.company;

public class Processor extends ComputerPart {

    private ComputerPart computerPart;
    private int numOfCores;
    private int processorSpeed;
    private boolean isProcessing;

    public ComputerPart getComputerPart() {
        return computerPart;
    }

    public void setComputerPart(ComputerPart computerPart) {
        this.computerPart = computerPart;
    }

    public int getNumOfCores() {
        return numOfCores;
    }

    public void setNumOfCores(int numOfCores) {
        this.numOfCores = numOfCores;
    }

    public int getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(int processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public boolean isProcessing() {
        return isProcessing;
    }

    public void setProcessing(boolean processing) {
        isProcessing = processing;
    }

    public Processor(){

    }


}
