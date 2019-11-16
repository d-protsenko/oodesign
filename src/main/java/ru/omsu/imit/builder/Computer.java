package ru.omsu.imit.builder;

import ru.omsu.imit.builder.components.CPU;
import ru.omsu.imit.builder.components.RAM;

public class Computer {
    private CPU cpu;
    private RAM ram;
    private int romSize;
    private String osName;
    private boolean floppyDiskAvailable;

    public Computer() {
        floppyDiskAvailable = true;
    }

    public Computer(boolean isFloppyDiskAvailable) {
        this.floppyDiskAvailable = isFloppyDiskAvailable;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public int getRomSize() {
        return romSize;
    }

    public void setRomSize(int romSize) {
        this.romSize = romSize;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public boolean isFloppyDiskAvailable() {
        return floppyDiskAvailable;
    }

    public void setFloppyDiskAvailable(boolean floppyDiskAvailable) {
        this.floppyDiskAvailable = floppyDiskAvailable;
    }
}
