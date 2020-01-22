package com.paradox.core.ces.forms;

import com.paradox.core.ces.enchants.EnchantHandler;
import com.paradox.core.ces.obj.CustomEnchant;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;

public class FormStorage {
	public static FormWindowSimple enchanterMenu() {
		FormWindowSimple fs = new FormWindowSimple("&", StringUtils.translateColors("&b&lEnchanter Menu"));
		for (CustomEnchant ce : EnchantHandler.getAllEnchants()) {
			fs.addButton(new ElementButton(ce.getDisplayNameOfEnchantment()));
		}
		return fs;
	}
}
