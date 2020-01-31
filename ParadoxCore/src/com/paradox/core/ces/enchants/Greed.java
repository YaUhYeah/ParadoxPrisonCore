package com.paradox.core.ces.enchants;

import com.paradox.core.ces.obj.CustomEnchant;
import com.paradox.core.ces.obj.EnchantType;
import com.paradox.core.utils.StringUtils;

public class Greed extends CustomEnchant {

	private int level;

	public Greed(int level) {
		super("Greed", level, 1000, StringUtils.translateColors("&aGreed"), "Gain extra orbs for mining!", 2000,
				EnchantType.CUSTOM);
		this.level = level;
	}

	public Greed() {
		super("Greed", 1, 1000, StringUtils.translateColors("&aGreed"), "Gain extra orbs for mining!", 2000,
				EnchantType.CUSTOM);
	}

	public int getLevel() {
		return level;
	}

}
