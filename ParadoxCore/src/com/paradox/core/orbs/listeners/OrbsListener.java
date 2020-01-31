package com.paradox.core.orbs.listeners;

import com.paradox.core.utils.CEUtils;
import com.paradox.core.utils.MineUtils;
import com.paradox.core.utils.OrbEconomyUtils;
import com.paradox.core.utils.StringUtils;

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
			if (CEUtils.containsEnchantment(i, CEUtils.getCEByDisplayName(StringUtils.translateColors("&aGreed")))) {
				if (MineUtils.isLocInMine(e.getBlock().getLocation())) {
					int lvl = CEUtils.getLevelOfEnchantByDisplayName(StringUtils.translateColors("&aGreed"), i);
					double incr = lvl / 10.0D;
					int actualAmount = (int) Math.floor(incr);
					OrbEconomyUtils.addPlayerBalance(p, 1 + actualAmount);
				} else {
					OrbEconomyUtils.addPlayerBalance(p, 1);
				}
			}
		}
	}
}
