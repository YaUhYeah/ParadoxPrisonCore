package com.paradox.core.mines.obj;

import java.util.HashMap;

import cn.nukkit.block.Block;

public class MineComposition {

	private HashMap<Block, Integer> blocksByChance;

	public MineComposition(HashMap<Block, Integer> blocksByChance) {
		this.blocksByChance = blocksByChance;
	}

	public HashMap<Block, Integer> getBlocksByChance() {
		return blocksByChance;
	}

}
