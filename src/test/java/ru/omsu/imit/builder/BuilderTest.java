package ru.omsu.imit.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderTest {
    @Test
    public void testMacBuilder() {
        Computer mac = SingletoneDirector.buildComputer(new MacBuilder());
        assertEquals(256, mac.getRomSize());
        assertEquals(16, mac.getRam().getMemorySize());
        assertEquals("MacOS", mac.getOsName());
        assertEquals("I7-7700HQ", mac.getCpu().getName());
    }
    @Test
    public void testRegularBuilder() {
        Computer mac = SingletoneDirector.buildComputer(new PerfectBuilder());
        assertEquals(1024, mac.getRomSize());
        assertEquals(64, mac.getRam().getMemorySize());
        assertEquals("W10 EE", mac.getOsName());
        assertEquals("I9-9900k", mac.getCpu().getName());
    }
}
