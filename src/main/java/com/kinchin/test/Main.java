package com.kinchin.test;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("vida").setExecutor(new VidaCommand());




    }
}