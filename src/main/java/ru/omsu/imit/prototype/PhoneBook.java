package ru.omsu.imit.prototype;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook implements Cloneable {
    private Map<String, String> phonebook;

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    private PhoneBook(Map<String, String> pb) {
        this.phonebook = pb;
    }

    public void add(String name, String number) {
        phonebook.putIfAbsent(name, number);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public String getNumber(String name) {
        return phonebook.get(name);
    }

    @Override
    protected PhoneBook clone() {
        return new PhoneBook(new HashMap<>(phonebook));
    }
}
