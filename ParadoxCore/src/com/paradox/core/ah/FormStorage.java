package com.paradox.core.ah;

import com.paradox.core.utils.StringUtils;

import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;

public class FormStorage {

	public static FormWindowSimple AHMenu() {
		FormWindowSimple fs = new FormWindowSimple(StringUtils.translateColors("&9&lParadox Auctions"),
				StringUtils.translateColors("&b&l&nChoose an option below!"));
		fs.addButton(new ElementButton(StringUtils.translateColors("&bSell Item")));
		fs.addButton(new ElementButton(StringUtils.translateColors("&bView Listings")));
		fs.addButton(new ElementButton(StringUtils.translateColors("&bCheck Auction Info")));
		return fs;
	}

	public static FormWindowSimple NoItemInHnad() {
		FormWindowSimple fc = new FormWindowSimple(StringUtils.translateColors("&9&lParadox Auctions"),
				(StringUtils.translateColors("&cHold an item first!")));
		fc.addButton(new ElementButton(StringUtils.translateColors("&aMain menu")));
		return fc;
	}

	public static FormWindowCustom sellItem(Item item) {
		FormWindowCustom fc = new FormWindowCustom(StringUtils.translateColors("&9&lAh Sell"));
		fc.addElement(new ElementLabel(StringUtils.translateColors(
				"&fSelling your x" + item.getCount() + " &e" + item.getName() + (" &ffor how much? "))));
		fc.addElement(new ElementInput(StringUtils.translateColors("&fPrice"),StringUtils.translateColors("$")));
		fc.addElement(new ElementInput(StringUtils.translateColors("&fSeller Notes (optional):"),StringUtils.translateColors("Buy now, great value!")));
		return fc;
	}

}
