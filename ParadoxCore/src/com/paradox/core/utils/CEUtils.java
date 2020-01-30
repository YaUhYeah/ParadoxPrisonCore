package com.paradox.core.utils;


import com.paradox.core.ces.enchants.EnchantHandler;
import com.paradox.core.ces.obj.CustomEnchant;

import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;

public class CEUtils {

	public static CustomEnchant getCEByDisplayName(String displayName) throws NullPointerException {
		for (CustomEnchant ce : EnchantHandler.getAllEnchants()) {
			if (ce.getDisplayNameOfEnchantment().equals(displayName)) {
				return ce;
			}
		}
		return null;
	}

	public static int getLevelOfEnchantByDisplayName(String name, Item item) {
		if (item.getLore().length > 0) {
			for (int i = 0; i < item.getLore().length; i++) {
				if (item.getLore()[i].contains(name)) {
					return Integer.parseInt(TextFormat.clean(item.getLore()[i]).replaceAll("[^\\d.]", ""));
				}
			}
		}
		return 0;
	}

	public static boolean containsEnchantment(Item item, CustomEnchant ce) {
		if (StringUtils.stringContainsItemFromList(StringUtils.translateColors(ce.getDisplayNameOfEnchantment()), item.getLore())) {
			return true;
		}
		return false;
	}

}
