package com.paradox.core.mines.listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.paradox.core.mines.cmd.MineCommand;
import com.paradox.core.utils.ItemStorage;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;

public class MinesListener implements Listener {
	public static Config mines = MineCommand.mines;
	public static File minesFile = MineCommand.minesFile;
	List<Location> locsForMine = new ArrayList<>();

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (MineCommand.playersInSetupModeMine.containsKey(p)) {
			if (p.getInventory().getItemInHand().getCustomName().equals(ItemStorage.mineSetupWand().getCustomName())) {
				e.setCancelled();
				if (locsForMine.size() > 1) {
					mines.set("Mines." + MineCommand.playersInSetupModeMine.get(p) + ".minX",
							locsForMine.get(0).getX());
					mines.set("Mines." + MineCommand.playersInSetupModeMine.get(p) + ".minY",
							locsForMine.get(0).getY());
					mines.set("Mines." + MineCommand.playersInSetupModeMine.get(p) + ".minZ",
							locsForMine.get(0).getZ());
					mines.set("Mines." + MineCommand.playersInSetupModeMine.get(p) + ".maxX",
							locsForMine.get(1).getX());
					mines.set("Mines." + MineCommand.playersInSetupModeMine.get(p) + ".maxY",
							locsForMine.get(1).getY());
					mines.set("Mines." + MineCommand.playersInSetupModeMine.get(p) + ".maxZ",
							locsForMine.get(1).getZ());
					mines.set("Mines." + MineCommand.playersInSetupModeMine.get(p) + ".composition.1", 100);
					mines.save(minesFile);
					p.sendMessage(StringUtils.getPrefix()
							+ ("Mine: " + MineCommand.playersInSetupModeMine.get(p) + " Created!"));
					MineCommand.playersInSetupModeMine.remove(p);
					locsForMine.clear();
				}
				locsForMine.add(e.getBlock().getLocation());
				p.sendActionBar(StringUtils.translateColors("&bAdded location to mine region."));
			}
		}
	}

}
