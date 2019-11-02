package com.company;

public class OpticalDrive extends ComputerPart {

    private ComputerPart computerPart;
    private String driveType;
    private boolean isOpen;
    private boolean hasDisk;

    public OpticalDrive(){

    }

    public void openDrive(){

    }

    public void readDisk(){

    }

    public ComputerPart getComputerPart() {
        return computerPart;
    }

    public void setComputerPart(ComputerPart computerPart) {
        this.computerPart = computerPart;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isHasDisk() {
        return hasDisk;
    }

    public void setHasDisk(boolean hasDisk) {
        this.hasDisk = hasDisk;
    }
}
