package ru.omsu.imit.abstract_factory;

public class ClassicPhoneFactory implements PhoneFactory {
    @Override
    public Phone buildPhone() {
        return new Phone("el Classic");
    }
}
