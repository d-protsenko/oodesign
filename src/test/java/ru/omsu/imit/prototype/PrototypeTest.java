package ru.omsu.imit.prototype;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PrototypeTest {
    @Test
    public void TestSuccessClone() {
        PhoneBook pb = new PhoneBook();
        pb.add("Michael", "89991113322");
        PhoneBook pbCloned = pb.clone();
        pb.add("Dimitry", "89224449988");
        assertEquals(pb.getNumber("Michael"), pbCloned.getNumber("Michael"));
        assertNotEquals(pb.getNumber("Dimitry"), pbCloned.getNumber("Dimitry"));
    }
}
