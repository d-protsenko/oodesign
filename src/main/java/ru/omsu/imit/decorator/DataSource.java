package ru.omsu.imit.decorator;

public interface DataSource {
    void writeData(String data);

    String readData();
}
