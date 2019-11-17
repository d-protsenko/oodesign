package ru.omsu.imit.bridge;

import org.junit.Test;

public class BridgeTest {
    @Test
    public void exampleBridge() {
        DeviceTester.testDevice(new TV());
        DeviceTester.testDevice(new Radio());
    }
}
