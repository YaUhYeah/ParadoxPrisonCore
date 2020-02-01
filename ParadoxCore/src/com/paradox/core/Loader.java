package com.paradox.core;

import java.io.File;
import java.util.HashMap;

import com.creeperface.nukkit.placeholderapi.api.PlaceholderAPI;
import com.paradox.core.ces.listeners.EnchantListener;
import com.paradox.core.general.cmd.SellCommand;
import com.paradox.core.general.listeners.EventsListener;
import com.paradox.core.mines.cmd.MineCommand;
import com.paradox.core.mines.listeners.MinesListener;
import com.paradox.core.mines.obj.Mine;
import com.paradox.core.orbs.cmd.OrbsCmd;
import com.paradox.core.orbs.listeners.OrbsListener;
import com.paradox.core.ranks.cmd.RankupCommand;
import com.paradox.core.utils.GeneralUtils;
import com.paradox.core.utils.MineUtils;
import com.paradox.core.utils.OrbEconomyUtils;
import com.paradox.core.utils.RankUtils;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.NukkitRunnable;
import cn.nukkit.utils.Config;

public class Loader extends PluginBase {

	private static Loader loader;
	private Config playerCfg;
	private File playersFile;
	private Config minesCfg;
	private File minesFile;
	private Config worthCfg;
	private File worthFile;
	PlaceholderAPI api = PlaceholderAPI.getInstance();
	public static HashMap<Mine, Integer> mineReset = new HashMap<>();

	@Override
	public void onEnable() {
		getDataFolder().mkdirs();
		playersFile = new File(getDataFolder(), "players.yml");
		playerCfg = new Config(playersFile);
		minesFile = new File(getDataFolder(), "mines.yml");
		minesCfg = new Config(minesFile);
		worthFile = new File(getDataFolder(), "worth.yml");
		worthCfg = new Config(worthFile);
		GeneralUtils.setupWorthFile();
		api.visitorSensitivePlaceholder("playerorbs", (p, T) -> OrbEconomyUtils.getPlayersTokenBalance(p));
		api.visitorSensitivePlaceholder("prisonrank", (p, T) -> RankUtils.getRankByPlayer(p).getName());
		api.visitorSensitivePlaceholder("prestige", (p, T) -> RankUtils.getPrestigeLevelForPlayer(p));
		startMineResetTask();
		registerCommands();
		registerEvents();
	}

	public void startMineResetTask() {
		for (Mine m : MineUtils.getAllMinesFromConfig()) {
			new NukkitRunnable() {
				int i = 300;

				@Override
				public void run() {
					if (i <=0) {
						m.resetMine();
						i = 300;
					}
					for (Mine m : MineUtils.getAllMinesFromConfig()) {
						api.staticPlaceholder(m.getMineName() + "_resetMineDelay", T -> i,
								new String[0]);
					}
					i--;
				}
			}.runTaskTimer(this, 0, 20);
		}
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
		getServer().getCommandMap().register("sell", new SellCommand());
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

	public Config getWorthCfg() {
		return worthCfg;
	}

	public File getWorthFile() {
		return worthFile;
	}

}
