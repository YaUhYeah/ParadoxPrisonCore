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

	public static Item orbPouchTierTwo() {
		Item it = new Item(130);
		it.setCustomName(StringUtils.translateColors(
				"&b&lOrbs Pouch &r&7(Right Click)\nThis is a tier two Orbs Pouch!\n\n&f((Right Click for 10,000-100,000 orbs!))"));
		return it;
	}

	public static Item orbPouchTierThree() {
		Item it = new Item(130);
		it.setCustomName(StringUtils.translateColors(
				"&b&lOrbs Pouch &r&7(Right Click)\nThis is a tier three Orbs Pouch!\n\n&f((Right Click for 100,000-1,000,000 orbs!))"));
		return it;
	}

	public static Item sellBoosterTenMinutes(int multiplier) {
		Item it = new Item(347);
		it.setCustomName(StringUtils.translateColors("&b&l" + multiplier
				+ "x Sell Booster &r&7(Right Click)\nMultiplies the money from any items \nsold for 10 minutes.\n\n&f((Right Click to activate!))"));
		return it;
	}
	
	public static Item randomTag() {
		Item it = new Item(421);
		it.setCustomName(StringUtils.translateColors(
				"&a&lRandom Tag &r&7(Right Click)\nGives perms to a random tag in /tags.\n&7If you already have all tags, you get $250,000\n&f((Right click to redeem!))"));
		return it;
	}

	public static Item smallBomb() {
		Item it = new Item(381);
		it.setCustomName(StringUtils.translateColors(
				"&c&lSmall Bomb &r&7(Throw)\nCreates a &csmall&7 explosion when thrown into a mine.\n\n&f((Throw to detonate!))"));
		return it;
	}
	
	public static Item mediumBomb() {
		Item it = new Item(381);
		it.setCustomName(StringUtils.translateColors(
				"&c&lMedium Bomb &r&7(Throw)\nCreates a &cmedium-sized&7 explosion when thrown into a mine.\n\n&f((Throw to detonate!))"));
		return it;
	}

	public static Item largeBomb() {
		Item it = new Item(381);
		it.setCustomName(StringUtils.translateColors(
				"&c&lLarge Bomb &r&7(Throw)\nCreates a &clarge&7 explosion when thrown into a mine.\n\n&f((Throw to detonate!))"));
		return it;
	}

	public static Item orbsBoosterTenMinutes(int multiplier) {
		Item it = new Item(409);
		it.setCustomName(StringUtils.translateColors("&b&l" + multiplier
				+ "x Orbs Booster &r&7(Right Click)\nMultiplies the amount of orbs for \nmining for 10 minutes.\n\n&f((Right Click to activate!))"));
		return it;
	}

}
