package fr.unchat.catapi.menu.button;

import fr.unchat.catapi.menu.Menu;
import fr.unchat.catapi.utils.ItemBuilder;
import fr.unchat.catapi.utils.msg.TextUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class BackButton extends Button {
    private final Menu menu;

    public BackButton(Menu menu) {
        this.menu = menu;
    }

    @Override
    public ItemStack getItem() {
        return new ItemBuilder(Material.ARROW)
                .setName("&eRetour")
                .setLore(
                        "",
                        "&7Clic-gauche pour retourner au menu",
                        "&f" + TextUtil.translate(menu.getInfo().title()) + "&f.",
                        ""
                )
                .toItem();
    }

    @Override
    public void onClick(Player player, Menu menu, ClickType click) {
        if (!click.isLeftClick()) return;
        this.menu.displayTo(player);
    }
}
