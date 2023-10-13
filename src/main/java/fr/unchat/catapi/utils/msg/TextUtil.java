package fr.unchat.catapi.utils.msg;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class TextUtil {
    public String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String prefix(String prefix, String text) {
        return translate(prefix + " &7▪ &f" + text);
    }

    public String arrayToString(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]);
            if (i != args.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
