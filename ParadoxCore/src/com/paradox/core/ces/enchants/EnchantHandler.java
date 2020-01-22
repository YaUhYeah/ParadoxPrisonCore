package com.paradox.core.ces.enchants;

import java.util.ArrayList;
import java.util.List;

import com.paradox.core.ces.obj.CustomEnchant;

public class EnchantHandler {
	
	public static List<CustomEnchant> getAllEnchants(){
		List<CustomEnchant> enchants = new ArrayList<CustomEnchant>();
		enchants.add(new Magnet());
		return enchants;
	}

}
