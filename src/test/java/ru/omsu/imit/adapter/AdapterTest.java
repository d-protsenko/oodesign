package ru.omsu.imit.adapter;

import org.junit.Test;
import ru.omsu.imit.abstract_factory.Phone;

import static org.junit.Assert.assertEquals;

public class AdapterTest {
    private static final String zeroId = "00000000-0000-0000-0000-000000000000";

    @Test
    public void testPhoneToJson() {
        String model = "Test model";
        Phone phone = new Phone("Test model");
        phone.setId("0-0-0-0-0");
        assertEquals(
                "{\"id\":\"" + zeroId + "\",\"model\":\"" + model + "\"}",
                PhoneToJsonAdapter.convertPhoneToJson(phone));
    }
}
