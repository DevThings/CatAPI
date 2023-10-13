package fr.unchat.catapi.utils.msg;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ConversationUtil {
    @Getter
    private static Map<Player, Player> conversations = new HashMap<>();

    public void start(Player p, Player p1) {
        conversations.put(p, p1);
        conversations.put(p1, p);
    }

    public void stop(Player p, Player p1) {
        conversations.remove(p);
        conversations.remove(p1);
    }

    public void send(Player from, Player to, String message) {
        from.sendMessage(TextUtil.prefix("&eVOUS", message));
        to.sendMessage(TextUtil.prefix("&e" + from.getName(), message));
    }
}
