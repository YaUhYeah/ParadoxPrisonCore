package com.paradox.core.general.cmd;

import com.paradox.core.Loader;
import com.paradox.core.utils.ItemStorage;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;

public class BombCommand extends Command {

	public BombCommand() {
		super("bomb");
	}

	//bomb give <player> 1 small
	
	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (args.length != 4) {
			sender.sendMessage(StringUtils
					.translateColors("&b&l(!)&r&7 Proper usage: /bomb give <name> <amount> <small,medium,large>"));
			return false;
		}
		if (sender.hasPermission("paradox.owner")) {
			if (args[0].equals("give")) {
				Player t = Loader.getLoader().getServer().getPlayer(args[1]);
				if (t != null) {
					if (args[3].equals("small")) {
						try {
							Item bomb = ItemStorage.smallBomb();
							sender.sendMessage(StringUtils.getPrefix() + "Gave " + t.getName() + " x" + args[2]
									+ " small bomb.");
							t.sendMessage(StringUtils.getPrefix() + "Given a small bomb.");
							bomb.setCount(Integer.parseInt(args[2]));
							t.getInventory().addItem(bomb);
						} catch (NumberFormatException e) {
							sender.sendMessage(StringUtils.getPrefix()
									+ "Incorrect usage, must be integer for amount and multiplier.");
						}
					} else if (args[3].equals("medium")) {
						try {
							Item bomb = ItemStorage.mediumBomb();
							sender.sendMessage(StringUtils.getPrefix() + "Gave " + t.getName() + " x" + args[2]
									+ " medium bomb.");
							t.sendMessage(StringUtils.getPrefix() + "Given a medium sized bomb.");
							bomb.setCount(Integer.parseInt(args[2]));
							t.getInventory().addItem(bomb);
						} catch (NumberFormatException e) {
							sender.sendMessage(StringUtils.getPrefix()
									+ "Incorrect usage, must be integer for amount and multiplier.");
						}
					}else if (args[3].equals("large")) {
						try {
							Item bomb = ItemStorage.largeBomb();
							sender.sendMessage(StringUtils.getPrefix() + "Gave " + t.getName() + " x" + args[2]
									+ " large bomb.");
							t.sendMessage(StringUtils.getPrefix() + "Given a large sized bomb.");
							bomb.setCount(Integer.parseInt(args[2]));
							t.getInventory().addItem(bomb);
						} catch (NumberFormatException e) {
							sender.sendMessage(StringUtils.getPrefix()
									+ "Incorrect usage, must be integer for amount and multiplier.");
						}
					}
				}
			}
		} else {
			sender.sendMessage(StringUtils.getPrefix()
					+ "No permission to give boosters..");
		}
		return false;
	}

}
