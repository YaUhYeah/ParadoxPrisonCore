package com.paradox.core.ranks.cmd;

import com.paradox.core.Loader;
import com.paradox.core.ranks.obj.Rank;
import com.paradox.core.ranks.storage.RankStorage;
import com.paradox.core.utils.RankUtils;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import me.onebone.economyapi.EconomyAPI;

public class RankupCommand extends Command {

	public RankupCommand() {
		super("rankup");
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				Rank currentRank = RankUtils.getRankByPlayer(p);
				if (!currentRank.isLastRank()) {
					Rank nextRank = RankUtils.getNextRankByPlayer(p);
					if (EconomyAPI.getInstance().myMoney(p) >= currentRank.getCost()) {
						EconomyAPI.getInstance().reduceMoney(p, currentRank.getCost());
						RankUtils.setRankByPlayer(p, nextRank);
						p.sendMessage(StringUtils.getPrefix() + "You ranked up to " + nextRank.getName() + ".");
						return false;
					} else {
						p.sendMessage(StringUtils.getPrefix() + "You do not have enough money to rankup.");
						return false;
					}
				} else {
					if (EconomyAPI.getInstance().myMoney(p) >= currentRank.getCost()) {
						EconomyAPI.getInstance().reduceMoney(p, currentRank.getCost());
						RankUtils.setRankByPlayer(p, RankStorage.A);
						RankUtils.setPrestigeLevelForPlayer(p, 1);
						p.sendMessage(StringUtils.getPrefix() + "You have just prestiged to level "
								+ RankUtils.getPrestigeLevelForPlayer(p));
						for (Player o : Loader.getLoader().getServer().getOnlinePlayers().values()) {
							o.sendMessage(StringUtils.getPrefix() + p.getName() + " has just prestiged to level "
									+ RankUtils.getPrestigeLevelForPlayer(p));
						}
					}
				}
			}
		}
		return false;
	}

}
