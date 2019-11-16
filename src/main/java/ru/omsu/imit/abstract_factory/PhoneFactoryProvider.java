package ru.omsu.imit.abstract_factory;

import java.util.HashMap;
import java.util.Map;

public class PhoneFactoryProvider {
    private Map<String, PhoneFactory> factoryMap;

    public PhoneFactoryProvider() {
        factoryMap = new HashMap<>();
        factoryMap.put("modern", new ModernPhoneFactory());
        factoryMap.put("classic", new ClassicPhoneFactory());
    }

    public PhoneFactory getPhoneFactory(final String type) {
        if (!factoryMap.containsKey(type)) {
            return null;
        }
        return factoryMap.get(type);
    }
}
