package ru.omsu.imit.abstract_factory;

public class ModernPhoneFactory implements PhoneFactory {
    @Override
    public Phone buildPhone() {
        return new Phone("Modern");
    }
}
