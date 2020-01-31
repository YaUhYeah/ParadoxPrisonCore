package com.paradox.core.ces.enchants;

import com.paradox.core.ces.obj.CustomEnchant;
import com.paradox.core.ces.obj.EnchantType;
import com.paradox.core.utils.StringUtils;

public class Fortune extends CustomEnchant {
	private int level;

	public Fortune(int level) {
		super("Fortune", level, 25, StringUtils.translateColors("&7Fortune"), "More drops for mining!",
				7500, EnchantType.VANILLA);
		this.level = level;
	}

	public Fortune() {
		super("Fortune", 1, 25, StringUtils.translateColors("&7Fortune"), "More drops for mining!",
				7500, EnchantType.VANILLA);	}

	public int getLevel() {
		return level;
	}
}
