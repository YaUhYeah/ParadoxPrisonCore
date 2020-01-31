package com.paradox.core;

import java.io.File;

import com.paradox.core.ces.listeners.EnchantListener;
import com.paradox.core.general.listeners.EventsListener;
import com.paradox.core.mines.cmd.MineCommand;
import com.paradox.core.mines.listeners.MinesListener;
import com.paradox.core.orbs.cmd.OrbsCmd;
import com.paradox.core.orbs.listeners.OrbsListener;
import com.paradox.core.ranks.cmd.RankupCommand;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class Loader extends PluginBase {

	private static Loader loader;
	private Config playerCfg;
	private File playersFile;
	private Config minesCfg;
	private File minesFile;

	@Override
	public void onEnable() {
		getDataFolder().mkdirs();
		playersFile = new File(getDataFolder(), "players.yml");
		playerCfg = new Config(playersFile);
		minesFile = new File(getDataFolder(), "mines.yml");
		minesCfg = new Config(minesFile);
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
		getServer().getCommandMap().register("orbs", new OrbsCmd());
		getServer().getCommandMap().register("mines", new MineCommand());
		getServer().getCommandMap().register("rankup", new RankupCommand());
	}

	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new EventsListener(), this);
		getServer().getPluginManager().registerEvents(new OrbsListener(), this);
		getServer().getPluginManager().registerEvents(new EnchantListener(), this);
		getServer().getPluginManager().registerEvents(new MinesListener(), this);
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

	public Config getMinesCfg() {
		return minesCfg;
	}

	public File getMinesFile() {
		return minesFile;
	}

}
