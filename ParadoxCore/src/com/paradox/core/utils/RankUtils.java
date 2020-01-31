package com.paradox.core.utils;

import java.io.File;

import com.paradox.core.Loader;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;

public class RankUtils {

	public static Config players = Loader.getLoader().getPlayerCfg();
	public static File playersFile = Loader.getLoader().getPlayersFile();

	public static int getPrestigeLevelForPlayer(Player p) {
		return players.getInt("Players." + p.getName() + ".prestigeLevel");
	}

	//public static Rank getRankByPlayer(Player p) {
		//return players.getInt("Players." + p.getName() + ".prestigeLevel");
//	}
	
}
