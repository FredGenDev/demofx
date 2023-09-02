package com.example.demofx;

import java.util.UUID;

public class Participant {
    private UUID uuid;
    private String name;
    private Boolean present;

    public Participant(UUID uuid, String name, Boolean present) {

        this.uuid = uuid;
        this.name = name;
        this.present = present;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }
}
