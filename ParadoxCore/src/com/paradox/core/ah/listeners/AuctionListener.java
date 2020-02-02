package com.paradox.core.ah.listeners;

import com.paradox.core.ah.FormStorage;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;

public class AuctionListener implements Listener {

	@EventHandler
	public void onResponse(PlayerFormRespondedEvent e) {
		Player p = e.getPlayer();
		Item i = e.getPlayer().getInventory().getItemInHand();
		if (e.getWindow() != null) {
			if (e.getWindow() instanceof FormWindowSimple) {
				FormWindowSimple gui = (FormWindowSimple) e.getWindow();
				if (gui != null) {
					if (gui.getTitle().equals(StringUtils.translateColors("&9&lParadox Auctions"))) {
						if (gui.getResponse().getClickedButton().getText() != null) {
							String responseName = gui.getResponse().getClickedButton().getText();
							if (responseName != null) {
								if (responseName.equals(StringUtils.translateColors("&bSell Item"))) {
									p.removeAllWindows();
									if (i == null || i.getId() == 0) {
										p.showFormWindow(FormStorage.NoItemInHnad());
									} else {
										p.showFormWindow(FormStorage.sellItem(i));
									}
								} else if (responseName.equals(StringUtils.translateColors("&aMain menu"))) {
									p.removeAllWindows();
									p.showFormWindow(FormStorage.AHMenu());
								}
							}
						}
					}
				}
			} else if (e.getWindow() instanceof FormWindowCustom) {
				FormWindowCustom gui = (FormWindowCustom) e.getWindow();
				if (gui.getTitle().equals(StringUtils.translateColors("&9&lAh Sell"))) {
					
				}
			}
		}
	}

}
