package com.paradox.core;

import com.paradox.core.utils.OrbEconomyUtils;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class OrbsCmd extends Command {

	public OrbsCmd() {
		super("orbs");
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage(StringUtils.getPrefix()+"Orbs: "+OrbEconomyUtils.getPlayersTokenBalance(p));
		}
		return false;
	}

}
