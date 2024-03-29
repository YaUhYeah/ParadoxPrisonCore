package com.paradox.core.mines.listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.paradox.core.mines.cmd.MineCommand;
import com.paradox.core.mines.obj.Mine;
import com.paradox.core.utils.ItemStorage;
import com.paradox.core.utils.MineUtils;
import com.paradox.core.utils.RankUtils;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;

public class MinesListener implements Listener {
	public static Config mines = MineCommand.mines;
	public static File minesFile = MineCommand.minesFile;
	List<Location> locsForMine = new ArrayList<>();

	@EventHandler
	public void onResponse(PlayerFormRespondedEvent e) {
		Player p = e.getPlayer();
		if (e.getWindow() != null) {
			if (e.getWindow() instanceof FormWindowSimple) {
				FormWindowSimple gui = (FormWindowSimple) e.getWindow();
				if (gui != null) {
					if (gui.getResponse().getClickedButton().getText() != null) {
						String responseName = gui.getResponse().getClickedButton().getText();
						if (responseName != null) {
							for (Mine m : MineUtils.getAllMinesFromConfig()) {
								if (responseName.equals(StringUtils.translateColors("&a" + m.getMineName()))) {
									if (RankUtils.getRankByName(m.getMineName()) != null) {
										if (RankUtils.getRankByName(m.getMineName()).getOrder() <= RankUtils
												.getRankByPlayer(p).getOrder()) {
											p.teleport(m.getTpLocation());
											p.sendActionBar(StringUtils
													.translateColors("&bTeleported to mine " + m.getMineName() + "."));
										} else {
											p.sendMessage(StringUtils.getPrefix()+"No perms for this mine! /rankup!");
										}
									} else {
										p.sendMessage(StringUtils.translateColors("&cERROR! Please alert an admin! ERROR CODE: 0x000001 Null."));
									}
								}
							}
						}
					}
				}
			}
		}

	}

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
					return;
				} else {
					locsForMine.add(e.getBlock().getLocation());
					p.sendActionBar(StringUtils.translateColors("&bAdded location to mine region."));
				}
			}
		}
	}

}
