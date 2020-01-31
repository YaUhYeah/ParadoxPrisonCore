package com.paradox.core.utils;

import cn.nukkit.item.Item;

public class ItemStorage {
	
	public static Item mineSetupWand() {
		Item mineWand = new Item(277);
		mineWand.setCustomName(StringUtils.translateColors("&e&lMineWand"));
		return mineWand;
	}

}
