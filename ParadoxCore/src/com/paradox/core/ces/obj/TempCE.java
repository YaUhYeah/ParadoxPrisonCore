package com.paradox.core.ces.obj;

public class TempCE {

	private CustomEnchant ce;
	private int level;
	private int cost;

	public TempCE(CustomEnchant ce, int level, int cost) {
		super();
		this.ce = ce;
		this.level = level;
		this.cost = cost;
	}

	public CustomEnchant getCe() {
		return ce;
	}

	public int getLevel() {
		return level;
	}

	public int getCost() {
		return cost;
	}

}
