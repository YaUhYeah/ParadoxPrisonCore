package com.paradox.core.mines.obj;

import cn.nukkit.level.Level;
import cn.nukkit.level.Location;

public class MineRegion {

	private Location locMin;
	private Location locMax;
	private Level lvl;

	public MineRegion(Location locMax, Location locMin, Level lvl) {
		this.locMin = locMin;
		this.locMax = locMax;
		this.lvl = lvl;
	}

	public boolean isInRegion(Location pLoc) {
		return pLoc.getLevel().equals(locMax.getLevel())
				&& (pLoc.getX() >= locMin.getX() && pLoc.getX() <= locMax.getX() && pLoc.getY() >= locMin.getY())
				&& pLoc.getY() <= locMax.getY() && pLoc.getZ() >= locMin.getZ() && pLoc.getZ() <= locMax.getZ();
	}

	public Level getLvl() {
		return lvl;
	}

	public Location getLocMin() {
		return locMin;
	}

	public Location getLocMax() {
		return locMax;
	}

}
