package ru.omsu.imit.builder.components;

public class CPU {
    private String name;
    private int bits;
    private int clockRate;

    public CPU(String name, int bits, int clockRate) {
        this.name = name;
        this.bits = bits;
        this.clockRate = clockRate;
    }

    public String getName() {
        return name;
    }

    public int getBits() {
        return bits;
    }

    public int getClockRate() {
        return clockRate;
    }
}
