package com.company;

public class Memory extends ComputerPart {

    private ComputerPart computerPart;
    private String memoryType;
    private int memorySize;
    private int memorySpeed;
    private boolean isFull;

    public Memory() {

    }

    public ComputerPart getComputerPart() {
        return computerPart;
    }

    public void setComputerPart(ComputerPart computerPart) {
        this.computerPart = computerPart;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getMemorySpeed() {
        return memorySpeed;
    }

    public void setMemorySpeed(int memorySpeed) {
        this.memorySpeed = memorySpeed;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
