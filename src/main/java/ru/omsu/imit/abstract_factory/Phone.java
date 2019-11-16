package ru.omsu.imit.abstract_factory;

import java.util.UUID;

public class Phone {
    private UUID id;
    private String model;
    private String version;

    public Phone(final String model) {
        this.model = model;
        this.id = UUID.randomUUID();
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(final String id) {
        this.id = UUID.fromString(id);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }
}
