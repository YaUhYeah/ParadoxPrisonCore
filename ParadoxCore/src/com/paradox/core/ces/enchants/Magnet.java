package com.paradox.core.ces.enchants;

import com.paradox.core.ces.obj.CustomEnchant;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;

public class Magnet extends CustomEnchant implements Listener {

	public Magnet() {
		super("Magnet", 1, 1, StringUtils.translateColors("&fMagnet"),
				"Automatically places broken blocks into inventory!");
	}

	@EventHandler
	public void onMine(BlockBreakEvent e) {
		Item tool = e.getItem();
		if (tool.getCustomName().contains("&fMagnet 1")) {
			PlayerInventory inventoryAutoAdd = e.getPlayer().getInventory();
			Item[] itemsToAdd = e.getDrops();
			if (!e.isCancelled()) {
				inventoryAutoAdd.addItem(itemsToAdd);
			} else {
				inventoryAutoAdd.addItem(itemsToAdd);
			}
		}
	}

}
