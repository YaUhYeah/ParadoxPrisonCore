package com.paradox.core.utils;

import cn.nukkit.item.Item;

public class ItemStorage {

	public static Item mineSetupWand() {
		Item mineWand = new Item(277);
		mineWand.setCustomName(StringUtils.translateColors("&e&lMineWand"));
		return mineWand;
	}

	public static Item orbPouchTierOne() {
		Item it = new Item(130);
		it.setCustomName(StringUtils.translateColors(
				"&b&lOrbs Pouch &r&7(Right Click)\nThis is a tier one Orbs Pouch!\n\n&f((Right Click for 1,000-10,000 orbs!))"));
		return it;
	}

}
