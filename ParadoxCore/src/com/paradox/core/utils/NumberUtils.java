package com.paradox.core.utils;

public class NumberUtils {

	public static int getCostOfEnchantmentByLevel(int level, int multiplier) {
		return level * multiplier;
	}

	public static int getMins(int input) {
		return ((input % 86400) % 3600) / 60;
	}

}
