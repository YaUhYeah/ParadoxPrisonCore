package com.paradox.core.mines.obj;

import com.paradox.core.Loader;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.level.Location;

public class Mine {

	private MineRegion region;
	private String mineName;
	private MineComposition mineComposition;
	private Location tpLocation;

	public Mine(MineRegion region, String mineName, MineComposition mineComposition, Location tpLocation) {
		this.region = region;
		this.mineName = mineName;
		this.mineComposition = mineComposition;
		this.tpLocation = tpLocation;
	}

	public void resetMine() {
		for (Player o : Loader.getLoader().getServer().getOnlinePlayers().values()) {
			if (region.isInRegion(o.getLocation())) {
				o.teleport(tpLocation);
			}
		}
		double maxX = region.getLocMax().getX();
		double maxY = region.getLocMax().getY();
		double maxZ = region.getLocMax().getZ();
		double minX = region.getLocMin().getX();
		double minY = region.getLocMin().getY();
		double minZ = region.getLocMin().getZ();
		for (int x = (int) minX; x <= maxX; x++) {
			for (int y = (int) minY; y <= maxY; y++) {
				for (int z = (int) minZ; z <= maxZ; z++) {
					region.getLvl().setBlock(new Location(x, y, z), Block.get(Block.STONE));
				}
			}
		}
	}

	public MineRegion getRegion() {
		return region;
	}

	public void setRegion(MineRegion region) {
		this.region = region;
	}

	public String getMineName() {
		return mineName;
	}

	public void setMineName(String mineName) {
		this.mineName = mineName;
	}

	public MineComposition getMineComposition() {
		return mineComposition;
	}

	public void setMineComposition(MineComposition mineComposition) {
		this.mineComposition = mineComposition;
	}

	public Location getTpLocation() {
		return tpLocation;
	}

	public void setTpLocation(Location tpLocation) {
		this.tpLocation = tpLocation;
	}

}
