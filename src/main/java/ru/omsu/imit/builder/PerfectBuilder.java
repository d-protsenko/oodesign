package ru.omsu.imit.builder;

import ru.omsu.imit.builder.components.CPU;
import ru.omsu.imit.builder.components.RAM;

public class PerfectBuilder implements ComputerBuilder {
    private Computer basic;

    @Override
    public void buildCpu() {
        basic.setCpu(new CPU("I9-9900k", 64, 4));
    }

    @Override
    public void buildRom() {
        basic.setRomSize(1024);
    }

    @Override
    public void buildRam() {
        basic.setRam(new RAM(64));
    }

    @Override
    public void buildOs() {
        basic.setOsName("W10 EE");
    }

    @Override
    public void createNewComputer() {
        basic = new Computer(false);
    }

    @Override
    public Computer getComputer() {
        return basic;
    }
}
