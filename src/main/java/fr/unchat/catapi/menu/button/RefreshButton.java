package fr.unchat.catapi.menu.button;

import fr.unchat.catapi.menu.Menu;
import fr.unchat.catapi.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class RefreshButton extends Button {
    @Override
    public ItemStack getItem() {
        return new ItemBuilder(Material.ARROW)
                .setName("&7» &fRafraichir")
                .setLore(
                        "",
                        "&7Clic-gauche: Rafraîchir le menu.",
                        ""
                )
                .toItem();
    }

    @Override
    public void onClick(Player player, Menu menu, ClickType click) {
        if (!click.isLeftClick()) return;
        menu.displayTo(player);
    }
}
