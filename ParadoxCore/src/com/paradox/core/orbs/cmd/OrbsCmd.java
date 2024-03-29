package com.paradox.core.orbs.cmd;

import com.paradox.core.Loader;
import com.paradox.core.utils.ItemStorage;
import com.paradox.core.utils.OrbEconomyUtils;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;

public class OrbsCmd extends Command {

	public OrbsCmd() {
		super("orbs");
	}// orbs givepouch {name} 1 1

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				p.sendMessage(StringUtils.getPrefix() + "Orbs: " + OrbEconomyUtils.getPlayersTokenBalance(p));
				return false;
			}
		}
		if (sender.hasPermission("paradox.owner")) {
			if (args.length == 3) {
				if (args[0].equals("give")) {
					Player target = Loader.getLoader().getServer().getPlayer(args[1]);
					if (target != null) {
						try {
							int amount = Integer.parseInt(args[2]);
							OrbEconomyUtils.addPlayerBalance(target, amount);
							target.sendMessage(StringUtils.getPrefix() + "You were given " + amount + " orbs!");
							sender.sendMessage(
									StringUtils.getPrefix() + "Gave " + target.getName() + " " + amount + " orbs!");
						} catch (NumberFormatException e) {
							sender.sendMessage(StringUtils.getPrefix() + "You must specify a number for amount.");
						}
					} else {
						sender.sendMessage(StringUtils.getPrefix() + "That player is not online.");
					}
				} else if (args[0].equals("remove")) {
					Player target = Loader.getLoader().getServer().getPlayer(args[1]);
					if (target != null) {
						try {
							int amount = Integer.parseInt(args[2]);
							OrbEconomyUtils.removePlayerBalance(target, amount);
							target.sendMessage(StringUtils.getPrefix() + "You have had " + amount
									+ " orbs removed from your balance!");
							sender.sendMessage(StringUtils.getPrefix() + "Removed " + amount + " orbs from"
									+ target.getName() + "'s balance. ");
						} catch (NumberFormatException e) {
							sender.sendMessage(StringUtils.getPrefix() + "You must specify a number for amount.");
						}
					} else {
						sender.sendMessage(StringUtils.getPrefix() + "That player is not online.");
					}
				} else if (args[0].equals("set")) {
					Player target = Loader.getLoader().getServer().getPlayer(args[1]);
					if (target != null) {
						try {
							int amount = Integer.parseInt(args[2]);
							OrbEconomyUtils.setPlayerBalance(target, amount);
							sender.sendMessage(
									StringUtils.getPrefix() + "Set " + target.getName() + "'s orbs to amount " + amount);
						} catch (NumberFormatException e) {
							sender.sendMessage(StringUtils.getPrefix() + "You must specify a number for amount.");
						}
					} else {
						sender.sendMessage(StringUtils.getPrefix() + "That player is not online.");
					}
				}
			} else if (args.length == 4) {
				if (args[0].equals("givepouch")) {
					Player target = Loader.getLoader().getServer().getPlayer(args[1]);
					if (target != null) {
						try {
							int amount = Integer.parseInt(args[2]);
							int tier = Integer.parseInt(args[3]);
							switch (tier) {
							case 1:
								Item i = ItemStorage.orbPouchTierOne();
								i.setCount(amount);
								target.getInventory().addItem(i);
								target.sendMessage(StringUtils.getPrefix() + "You were given a Tier one OrbPouch!");
								sender.sendMessage(StringUtils.getPrefix() + "Gave " + target.getName()
										+ " a tier one orb pouch!");
								break;
							case 2: 
								Item i1 = ItemStorage.orbPouchTierTwo();
								i1.setCount(amount);
								target.getInventory().addItem(i1);
								target.sendMessage(StringUtils.getPrefix() + "You were given a Tier two OrbPouch!");
								sender.sendMessage(StringUtils.getPrefix() + "Gave " + target.getName()
										+ " a tier two orb pouch!");
								break;
							case 3:
								Item i11 = ItemStorage.orbPouchTierThree();
								i11.setCount(amount);
								target.getInventory().addItem(i11);
								target.sendMessage(StringUtils.getPrefix() + "You were given a Tier three OrbPouch!");
								sender.sendMessage(StringUtils.getPrefix() + "Gave " + target.getName()
										+ " a tier three orb pouch!");
								break;
							}
						} catch (NumberFormatException e) {
							sender.sendMessage(StringUtils.getPrefix() + "You must specify a number for amount.");
						}
					}
				}
			}
		} else {
			sender.sendMessage(StringUtils.getPrefix() + "No permission for that cmd!");
		}
		return false;
	}

}
