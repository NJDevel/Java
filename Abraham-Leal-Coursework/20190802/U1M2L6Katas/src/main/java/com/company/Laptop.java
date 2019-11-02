package com.company;

public class Laptop extends ComputerPart{

    private ComputerPart computerPart;
    private Processor processor;
    private Memory memory;
    private OpticalDrive opticalDrive;
    private Display display;

    public Laptop(){

    }

    public void power(){

    }

    public void sleep(){

    }

    public ComputerPart getComputerPart() {
        return computerPart;
    }

    public void setComputerPart(ComputerPart computerPart) {
        this.computerPart = computerPart;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public OpticalDrive getOpticalDrive() {
        return opticalDrive;
    }

    public void setOpticalDrive(OpticalDrive opticalDrive) {
        this.opticalDrive = opticalDrive;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
