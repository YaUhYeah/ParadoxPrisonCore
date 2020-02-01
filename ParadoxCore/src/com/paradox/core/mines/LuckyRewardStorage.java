package com.paradox.core.mines;

import java.util.ArrayList;
import java.util.List;

import com.paradox.core.mines.obj.LuckyReward;

public class LuckyRewardStorage {

	public static LuckyReward prizeOne = new LuckyReward(30, "1,000 Orbs", "orbs give {name} 1000");
	public static LuckyReward prizeTwo = new LuckyReward(20, "1x Basic Key", "cc give {name} Basic 1");
	public static LuckyReward prizeThree = new LuckyReward(10, "Orbs Pouch Tier I", "orbs givepouch {name} 1 1");
	public static LuckyReward prizeFour = new LuckyReward(5, "10,000 Orbs", "orbs give {name} 10000");
	public static LuckyReward prizeFive = new LuckyReward(35, "$10,000", "givemoney {name} 10000");

	public static List<LuckyReward> rews() {
		List<LuckyReward> rews = new ArrayList<LuckyReward>();
		rews.add(prizeOne);
		rews.add(prizeTwo);
		rews.add(prizeThree);
		rews.add(prizeFour);
		rews.add(prizeFive);
		return rews;
	}

}
