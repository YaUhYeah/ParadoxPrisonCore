package com.paradox.core.mines.cmd;

import java.io.File;
import java.util.HashMap;

import com.paradox.core.Loader;
import com.paradox.core.utils.ItemStorage;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.Config;

public class MineCommand extends Command {
	public static Config mines = Loader.getLoader().getMinesCfg();
	public static File minesFile = Loader.getLoader().getMinesFile();
	public static HashMap<Player, String> playersInSetupModeMine = new HashMap<>();

	public MineCommand() {
		super("mine");
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (args.length != 2) {
			sendHelpMessage(sender);
			return false;
		}

		if (args[0].equals("setup")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (playersInSetupModeMine.values().size() < 1) {
					playersInSetupModeMine.put(p, args[1]);
					p.sendMessage(StringUtils.getPrefix() + "Now in Mine Setup Mode!");
					p.sendMessage(StringUtils.getPrefix() + "Please break two blocks to mark the region for mine: "
							+ args[1] + ".");
					p.sendMessage(StringUtils.getPrefix()
							+ StringUtils.translateColors("&cType 'cancel' without '' to cancel setup."));
					p.getInventory().addItem(ItemStorage.mineSetupWand());
					mines.set("Mines." + args[1] + ".name", args[1]);
					mines.set("Mines." + args[1] + ".tpLocX", p.getLocation().getX());
					mines.set("Mines." + args[1] + ".tpLocY", p.getLocation().getY());
					mines.set("Mines." + args[1] + ".tpLocZ", p.getLocation().getZ());
					mines.set("Mines." + args[1] + ".tpLocLevelName", p.getLevel().getName());
					mines.save(minesFile);
				} else {
					p.sendMessage(StringUtils.getPrefix() + "Another player is already setting up mines!");
				}
			}
		}
		return false;
	}

	public void sendHelpMessage(CommandSender sender) {
		sender.sendMessage(StringUtils.translateColors("&cIncorrect Usage!"));
	}
}
