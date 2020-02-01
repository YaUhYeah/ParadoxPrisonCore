package com.paradox.core.general.listeners;

import java.io.File;

import com.paradox.core.Loader;
import com.paradox.core.ces.forms.FormStorage;
import com.paradox.core.ranks.storage.RankStorage;
import com.paradox.core.utils.CooldownManager;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerInteractEvent.Action;
import cn.nukkit.item.Item;
import cn.nukkit.scheduler.NukkitRunnable;
import cn.nukkit.utils.Config;

public class EventsListener implements Listener {
	public static Config players = Loader.getLoader().getPlayerCfg();
	public static File playersFile = Loader.getLoader().getPlayersFile();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (!players.exists("Players." + e.getPlayer().getName() + ".rank")) {
			players.set("Players." + e.getPlayer().getName() + ".rank", RankStorage.A.getName());
			players.set("Players." + e.getPlayer().getName() + ".prestigeLevel", 0);
			players.save(playersFile);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Item i = p.getInventory().getItemInHand();
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (i.getId() == 278) {
				CooldownManager cm = new CooldownManager();
				int timeLeft = cm.getCooldown(p.getUniqueId());
				if (timeLeft == 0) {
					p.showFormWindow(FormStorage.enchanterMenu());
					cm.setCooldown(p.getUniqueId(), 3);
					new NukkitRunnable() {
						@Override
						public void run() {
							int timeLeft = cm.getCooldown(p.getUniqueId());
							cm.setCooldown(p.getUniqueId(), --timeLeft);
							if (timeLeft <= 0) {
								this.cancel();
							}
						}
					}.runTaskTimer(Loader.getLoader(), 20, 20);
				}
			}
		}
	}

}
