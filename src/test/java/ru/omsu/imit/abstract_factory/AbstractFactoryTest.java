package ru.omsu.imit.abstract_factory;

import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class AbstractFactoryTest {
    private PhoneFactoryProvider pfp = new PhoneFactoryProvider();

    @Test
    public void testBuildModernPhone() {
        Phone phone = pfp.getPhoneFactory("modern").buildPhone();
        assertEquals("Modern", phone.getModel());
    }

    @Test
    public void testBuildClassicPhone() {
        Phone phone = pfp.getPhoneFactory("classic").buildPhone();
        assertEquals("el Classic", phone.getModel());
    }
    @Test
    public void testGetFactoryThatNotExist() {
        PhoneFactory pf = pfp.getPhoneFactory("rng");
        assertNull(pf);
    }
}
