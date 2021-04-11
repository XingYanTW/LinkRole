package me.xingyan.linkrole;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    public static Plugin plugin = null;

    private final discordsrvListener discordsrvListener = new discordsrvListener();

    @Override
    public void onEnable() {
        // Plugin startup logic
        DiscordSRV.api.subscribe(discordsrvListener);
        getServer().getPluginManager().registerEvents(this, this);
        plugin = this;
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
