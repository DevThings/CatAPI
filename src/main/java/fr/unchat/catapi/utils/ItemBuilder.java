package fr.unchat.catapi.utils;

import fr.unchat.catapi.utils.msg.TextUtil;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class ItemBuilder {
    private ItemStack item;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
    }

    public ItemBuilder setName(String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(TextUtil.translate(name));
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchant, int level) {
        item.addEnchantment(enchant, level);
        return this;
    }

    public ItemBuilder addEnchants(Map<Enchantment, Integer> map) {
        map.forEach(((enchantment, integer) -> {
            addEnchant(enchantment, integer);
        }));
        return this;
    }

    public ItemBuilder addUnsafeEnchant(Enchantment enchant, int level) {
        item.addUnsafeEnchantment(enchant, level);
        return this;
    }

    public ItemBuilder glow() {
        item.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.addEnchantment(Enchantment.DURABILITY, 1);
        return this;
    }

    public ItemStack toItem() {
        return item;
    }
}
