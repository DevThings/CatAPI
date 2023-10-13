package fr.unchat.catapi.commands;

import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class CatCommand implements CommandExecutor {
    @Getter
    private final CommandInfo info;

    public CatCommand() {
        info = getClass().getDeclaredAnnotation(CommandInfo.class);
        Objects.requireNonNull(info, "CAT » Command informations must not be null");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!info.permission().isEmpty()) {
            if (!sender.hasPermission(info.permission())) {
                sender.sendMessage("§cYou don't have the permission to execute this.");
                return false;
            }
        }

        if (info.needPlayer()) {
            if (!(sender instanceof Player p)) {
                sender.sendMessage("§cYou need to be online to execute this.");
                return false;
            }

            execute(p, args);
            return true;
        }

        execute(sender, args);
        return true;
    }

    public void execute(Player player, String[] args) {}
    public void execute(CommandSender sender, String[] args) {}
}
