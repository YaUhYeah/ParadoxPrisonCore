package com.paradox.core;

import com.paradox.core.ces.enchants.Magnet;

import cn.nukkit.plugin.PluginBase;

public class Loader extends PluginBase {

	private static Loader loader;
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
	public void onLoad() {
		loader = this;
	}
	
	public void registerCommands() {
		
	}
	
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new Magnet(), this);
	}
	
	public static Loader getLoader() {
		return loader;
	}
	
}
