package ru.omsu.imit.builder;

public interface ComputerBuilder {
    void buildCpu();

    void buildRom();

    void buildRam();

    void buildOs();

    void createNewComputer();

    Computer getComputer();
}
