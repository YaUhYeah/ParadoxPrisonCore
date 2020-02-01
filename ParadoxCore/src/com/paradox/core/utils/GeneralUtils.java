package com.paradox.core.utils;

import java.util.Random;

import cn.nukkit.Player;
import cn.nukkit.item.Item;

public class GeneralUtils {

	public static void pop(Item item, Player p, int amount) {
		p.getInventory().remove(item);
		item.setCount(item.getCount() - amount);
		p.getInventory().addItem(item);
	}

	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
