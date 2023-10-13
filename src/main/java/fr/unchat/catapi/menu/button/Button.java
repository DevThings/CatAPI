package fr.unchat.catapi.menu.button;

import fr.unchat.catapi.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public abstract class Button {
    public abstract ItemStack getItem();

    public abstract void onClick(Player player, int slot, Menu menu, ClickType click);

    public void close(Player player) {
        player.closeInventory();
    }
}
