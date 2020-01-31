package com.paradox.core.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.paradox.core.Loader;
import com.paradox.core.mines.obj.Mine;
import com.paradox.core.mines.obj.MineComposition;
import com.paradox.core.mines.obj.MineRegion;

import cn.nukkit.block.Block;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;

public class MineUtils {
	public static Config minescfg = Loader.getLoader().getMinesCfg();
	public static File minesFile = Loader.getLoader().getMinesFile();

	public List<Mine> getAllMinesFromConfig() {
		List<Mine> mines = new ArrayList<Mine>();
		for (String key : minescfg.getSection("Mines").getKeys(false)) {
			Location tpLoc = new Location(minescfg.getDouble("Mines." + key + ".tpLocX"),
					(minescfg.getDouble("Mines." + key + ".tpLocY")), (minescfg.getDouble("Mines." + key + ".tpLocz")),
					Loader.getLoader().getServer()
							.getLevelByName(minescfg.getString("Mines." + key + ".tpLocLevelName")));
			String name = minescfg.getString("Mines." + key + ".name");
			Location minLoc = new Location(minescfg.getDouble("Mines." + key + ".minX"),
					minescfg.getDouble("Mines." + key + ".minY"), minescfg.getDouble("Mines." + key + ".minZ"),
					Loader.getLoader().getServer()
							.getLevelByName(minescfg.getString("Mines." + key + ".tpLocLevelName")));
			Location maxLoc = new Location(minescfg.getDouble("Mines." + key + ".maxX"),
					minescfg.getDouble("Mines." + key + ".minY"), minescfg.getDouble("Mines." + key + ".maxZ"),
					Loader.getLoader().getServer()
							.getLevelByName(minescfg.getString("Mines." + key + ".tpLocLevelName")));
			HashMap<Block, Integer> maps = new HashMap<>();
			for (String comp : minescfg.getSection("Mines." + key + ".composition").getKeys(false)) {
				maps.put(Block.get(Integer.parseInt(comp)), minescfg.getInt("Mines." + key + ".composition." + comp));
			}
			MineRegion mr = new MineRegion(minLoc, maxLoc, Loader.getLoader().getServer()
					.getLevelByName(minescfg.getString("Mines." + key + ".tpLocLevelName")));
			MineComposition cmp = new MineComposition(maps);
			Mine mine = new Mine(mr, name, cmp, tpLoc);
			mines.add(mine);
		}
		return mines;
	}
}