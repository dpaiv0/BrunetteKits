package xyz.paiva.brunettekits.handler;

import xyz.paiva.brunettekits.kits.Kit;

import java.util.ArrayList;
import java.util.List;

public class KitHandler {

    private static KitHandler instance;

    public static KitHandler getInstance() {
        if (instance == null) {
            instance = new KitHandler();
        }
        return instance;
    }

    private final List<Kit> kits = new ArrayList<>();

    public void register(Kit kit) {
        kits.add(kit);
    }

    public List<Kit> retrieve() {
        return kits;
    }

    private KitHandler() {}

}
