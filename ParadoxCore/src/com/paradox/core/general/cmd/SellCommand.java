package com.paradox.core.general.cmd;

import java.io.File;

import com.paradox.core.Loader;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import me.onebone.economyapi.EconomyAPI;

public class SellCommand extends Command {
	public static Config worth = Loader.getLoader().getWorthCfg();
	public static File worthFile = Loader.getLoader().getWorthFile();

	public SellCommand() {
		super("sell");
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(StringUtils.getPrefix() + "Only players can use this command.");
			return false;
		}
		if (args.length == 0) {
			Player p = (Player) sender;
			sellInv(p);
		}
		return false;
	}

	public static void sellInv(Player p) {
		for (Item i : p.getInventory().getContents().values()) {
			if (canSell(i)) {
				EconomyAPI.getInstance().addMoney(p,
						worth.getDouble("worth." + i.getId()) * getNumberOfItemInv(i, p));
				p.sendMessage(StringUtils.getPrefix() + "Sold blocks mined for $"
						+ worth.getDouble("worth." + i.getId()) * getNumberOfItemInv(i, p) + ".");
				p.getInventory().remove(i);
			}
		}
	}
	
	public static void sellItem(Player p, Item item) {
		if (canSell(item)) {
			EconomyAPI.getInstance().addMoney(p,
					worth.getDouble("worth." + item.getId()));
			p.sendActionBar(StringUtils.translateColors("&b&l(!)&r&d AutoSell Enchant Activated!"));
		}
	}
	
	public static int getNumberOfItemInv(Item item, Player p) {
		int it = 0;
		for (Item i : p.getInventory().getContents().values()) {
			if (item.getId() == i.getId()) {
				it += i.getCount();
			}
		}
		return it;
	}

	public static boolean canSell(Item item) {
		for (String key : worth.getSection("worth").getKeys(false)) {
			if (item.getId() == Integer.parseInt(key)) {
				return true;
			}
		}
		return false;
	}

}
