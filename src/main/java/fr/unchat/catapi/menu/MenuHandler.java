package fr.unchat.catapi.menu;

import fr.unchat.catapi.menu.button.Button;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MenuHandler implements Listener {
    @Getter
    private static final MenuHandler instance = new MenuHandler();
    private final Map<Player, Menu> menus = new HashMap<>();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = ((Player) event.getWhoClicked());
        if (menus.get(player) != null) {
            Button button = menus.get(player).getItems(player).get(event.getSlot());
            button.onClick(player, event.getSlot(), menus.get(player), event.getClick());
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (menus.get(player) != null) menus.remove(player);
    }
}
