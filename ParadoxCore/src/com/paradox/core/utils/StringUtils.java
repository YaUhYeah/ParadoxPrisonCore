package com.paradox.core.utils;


import com.paradox.core.Loader;

import cn.nukkit.utils.TextFormat;

public class StringUtils {
	
	public static String translateColors(String message) {
		return TextFormat.colorize(message);
	}
	public static boolean stringContainsItemFromList(String inputStr, String[] items)
	{
	    for(int i =0; i < items.length; i++)
	    {
	        if(items[i].contains(inputStr))
	        {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static String getPrefix() {
		return translateColors("&b&l(&d&l!&b&l) &r&7");
	}
	
	public static void logError(String message) {
		Loader.getLoader().getLogger().alert(message);
	}
}
