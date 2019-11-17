package ru.omsu.imit.builder;

import ru.omsu.imit.builder.components.CPU;
import ru.omsu.imit.builder.components.RAM;

public class MacBuilder implements ComputerBuilder {
    private Computer mac;

    @Override
    public void buildCpu() {
        mac.setCpu(new CPU("I7-7700HQ", 64, 4));
    }

    @Override
    public void buildRom() {
        mac.setRomSize(256);
    }

    @Override
    public void buildRam() {
        mac.setRam(new RAM(16));
    }

    @Override
    public void buildOs() {
        mac.setOsName("MacOS");
    }

    @Override
    public void createNewComputer() {
        mac = new Computer();
    }

    @Override
    public Computer getComputer() {
        return mac;
    }
}
