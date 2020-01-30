package com.paradox.core;

import java.io.File;

import com.paradox.core.ces.listeners.EnchantListener;
import com.paradox.core.general.listeners.EventsListener;
import com.paradox.core.orbs.listeners.OrbsListener;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class Loader extends PluginBase {

	private static Loader loader;
	private Config playerCfg;
	private File playersFile;

	@Override
	public void onEnable() {
		getDataFolder().mkdirs();
		playersFile = new File(getDataFolder(), "players.yml");
		playerCfg = new Config(playersFile);
		registerCommands();
		registerEvents();
	}

	@Override
	public void onDisable() {

	}

	@Override
	public void onLoad() {
		loader = this;
	}

	public void registerCommands() {

	}

	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new EventsListener(), this);
		getServer().getPluginManager().registerEvents(new OrbsListener(), this);
		getServer().getPluginManager().registerEvents(new EnchantListener(), this);
	}

	public static Loader getLoader() {
		return loader;
	}

	public Config getPlayerCfg() {
		return playerCfg;
	}

	public File getPlayersFile() {
		return playersFile;
	}

}
