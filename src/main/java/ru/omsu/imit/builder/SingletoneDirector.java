package ru.omsu.imit.builder;

public class SingletoneDirector {
    public static Computer buildComputer(ComputerBuilder builder) {
        builder.createNewComputer();
        builder.buildCpu();
        builder.buildRom();
        builder.buildRam();
        builder.buildOs();
        return builder.getComputer();
    }
}
