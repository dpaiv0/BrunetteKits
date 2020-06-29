package xyz.paiva.brunettekits.prototypes.impl;

import xyz.paiva.brunettekits.prototypes.Prototype;

import java.util.UUID;

public class Account implements Prototype {

    private final UUID uniqueId;

    public Account(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

}
