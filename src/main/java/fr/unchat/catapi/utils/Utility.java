package fr.unchat.catapi.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class Utility {
    public Material getMaterialByName(String name) {
        return Material.getMaterial(name.toUpperCase());
    }

    public List<Material> getMaterialByName(String... names) {
        List<Material> mats = new ArrayList<>();
        for (String name : names) {
            mats.add(getMaterialByName(name));
        }
        return mats;
    }
}
