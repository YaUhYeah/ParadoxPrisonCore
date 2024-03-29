package com.paradox.core.mines.obj;

public class MineDelay {

	private Mine mine;
	private int delayCount;

	public MineDelay(Mine mine, int delayCount) {
		super();
		this.mine = mine;
		this.delayCount = delayCount;
	}

	public Mine getMine() {
		return mine;
	}

	public int getDelayCount() {
		return delayCount;
	}

}
