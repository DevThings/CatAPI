package fr.unchat.catapi.plugin;

import fr.unchat.catapi.commands.CatCommand;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CatPlugin extends JavaPlugin {
    @Getter
    private static CatPlugin instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    public void registerCommand(CatCommand command) {
        getCommand(command.getInfo().name()).setExecutor(command);
    }

    public void registerCommands(CatCommand... commands) {
        for (CatCommand command : commands) {
            registerCommand(command);
        }
    }

    public void registerEvent(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public void registerEvents(Listener... listeners) {
        for (Listener listener : listeners) {
            registerEvent(listener);
        }
    }
}
