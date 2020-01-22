package com.paradox.core.general.listeners;

import com.paradox.core.Loader;
import com.paradox.core.ces.forms.FormStorage;
import com.paradox.core.ces.tasks.FormOpenTask;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerInteractEvent.Action;
import cn.nukkit.item.Item;
import cn.nukkit.scheduler.TaskHandler;

public class EventsListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Item i = p.getInventory().getItemInHand();
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (i.getId() == 278) {
				FormOpenTask task = new FormOpenTask(Loader.getLoader());
				TaskHandler handler = Loader.getLoader().getServer().getScheduler().scheduleRepeatingTask(task, 20);
				task.setHandler(handler);
				if (!handler.isCancelled()) {
					p.sendMessage(StringUtils
							.translateColors("&b&lYou need to wait before opening the ce menu."));
				} else {
					p.showFormWindow(FormStorage.enchanterMenu());
				}
			}
		}
	}

}
