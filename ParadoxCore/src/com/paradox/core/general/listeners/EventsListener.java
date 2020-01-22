package com.paradox.core.general.listeners;

import com.paradox.core.Loader;
import com.paradox.core.ces.forms.FormStorage;
import com.paradox.core.utils.CooldownManager;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerInteractEvent.Action;
import cn.nukkit.item.Item;
import cn.nukkit.scheduler.NukkitRunnable;

public class EventsListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Item i = p.getInventory().getItemInHand();
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (i.getId() == 278) {
				p.showFormWindow(FormStorage.enchanterMenu());
				CooldownManager cm = new CooldownManager();
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
