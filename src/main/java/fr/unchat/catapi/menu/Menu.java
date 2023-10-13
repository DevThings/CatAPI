package fr.unchat.catapi.menu;

import fr.unchat.catapi.menu.button.Button;
import fr.unchat.catapi.utils.ItemBuilder;
import fr.unchat.catapi.utils.Utility;
import fr.unchat.catapi.utils.msg.TextUtil;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter @Setter
public abstract class Menu {
    private final MenuInfo info;
    private Inventory inventory;
    private Player viewer;

    public Menu() {
        info = getClass().getDeclaredAnnotation(MenuInfo.class);
        Objects.requireNonNull(info, "Menu must have informations");
        inventory = Bukkit.createInventory(null, info.slots(), TextUtil.translate(info.title()));
    }

    public void setSlotsVisible() {
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, new ItemBuilder(Utility.getMaterialByName("STAINED_GLASS_PANE"))
                        .setName("&0 ")
                        .toItem());
            }
        }
    }

    public abstract Map<Integer, Button> getItems(Player player);

    public void displayTo(Player player) {
        viewer = player;

        getItems(player).forEach((slot, button) -> {
            inventory.setItem(slot, button.getItem());
        });

        player.openInventory(inventory);
        MenuHandler.getInstance().getMenus().put(player, this);
    }

    public void restartMenu() {
        displayTo(viewer);
    }
}
