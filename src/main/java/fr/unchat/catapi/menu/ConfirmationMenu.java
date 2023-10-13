package fr.unchat.catapi.menu;

import fr.unchat.catapi.menu.button.Button;
import fr.unchat.catapi.utils.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Getter
@MenuInfo(title = "&7| &fConfirmation", slots = 27)
public class ConfirmationMenu extends Menu {
    private final Consumer<Player> callback;

    public ConfirmationMenu(Consumer<Player> callback) {
        this.callback = callback;
    }

    @Override
    public Map<Integer, Button> getItems(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        List<Integer> greenPane = List.of(0, 1, 2, 9, 11, 18, 19, 20);
        List<Integer> redPane = List.of(6, 7, 8, 15, 17, 24, 25, 26);

        for (Integer i : greenPane) {
            buttons.put(i, new Button() {
                @Override
                public ItemStack getItem() {
                    return new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE)
                            .setName("&0 ")
                            .toItem();
                }

                @Override
                public void onClick(Player player, Menu menu, ClickType click) {
                    restartMenu();
                }
            });
        }

        for (Integer i : redPane) {
            buttons.put(i, new Button() {
                @Override
                public ItemStack getItem() {
                    return new ItemBuilder(Material.RED_STAINED_GLASS_PANE)
                            .setName("&0 ")
                            .toItem();
                }

                @Override
                public void onClick(Player player, Menu menu, ClickType click) {
                    restartMenu();
                }
            });
        }

        buttons.put(10, new Button() {
            @Override
            public ItemStack getItem() {
                return new ItemBuilder(Material.EMERALD)
                        .setName("&aConfirmer")
                        .toItem();
            }

            @Override
            public void onClick(Player player, Menu menu, ClickType click) {
                getCallback().accept(player);
            }
        });

        buttons.put(16, new Button() {
            @Override
            public ItemStack getItem() {
                return new ItemBuilder(Material.REDSTONE)
                        .setName("&cAnnuler")
                        .toItem();
            }

            @Override
            public void onClick(Player player, Menu menu, ClickType click) {
                close(player);
            }
        });

        return buttons;
    }
}
