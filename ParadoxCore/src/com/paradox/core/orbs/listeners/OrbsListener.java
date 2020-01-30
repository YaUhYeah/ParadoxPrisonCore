package com.paradox.core.orbs.listeners;

import com.paradox.core.utils.OrbEconomyUtils;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.item.Item;

public class OrbsListener implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Item i = p.getInventory().getItemInHand();
		if (i.getId() == 278) {
			OrbEconomyUtils.addPlayerBalance(p, 1);
		}
	}

}
