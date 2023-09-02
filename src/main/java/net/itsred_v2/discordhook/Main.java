package net.itsred_v2.discordhook;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.itsred_v2.discordhook.listeners.OnJoinListener;
import net.itsred_v2.discordhook.listeners.OnQuitListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        registerEvent(new OnJoinListener(this));
        registerEvent(new OnQuitListener(this));
    }

    private void registerEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

}
