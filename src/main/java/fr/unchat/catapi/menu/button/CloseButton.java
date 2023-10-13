package fr.unchat.catapi.menu.button;

import fr.unchat.catapi.menu.Menu;
import fr.unchat.catapi.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class CloseButton extends Button {
    @Override
    public ItemStack getItem() {
        return new ItemBuilder(Material.BARRIER)
                .setName("&cFermer")
                .setLore(
                        "",
                        "&7Clic-gauche: Fermer le menu",
                        ""
                )
                .toItem();
    }

    @Override
    public void onClick(Player player, Menu menu, ClickType click) {
        if (!click.isLeftClick()) return;
        close(player);
    }
}
