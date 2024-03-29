package com.paradox.core.kits.listeners;

import java.io.File;
import java.time.Duration;

import com.paradox.core.Loader;
import com.paradox.core.kits.FormStorage;
import com.paradox.core.kits.KitHandler;
import com.paradox.core.kits.obj.Kit;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.Config;

public class KitsListener implements Listener {
	public static Config players = Loader.getLoader().getPlayerCfg();
	public static File playersFile = Loader.getLoader().getPlayersFile();

	@EventHandler
	public void onResponse(PlayerFormRespondedEvent e) {
		Player p = e.getPlayer();
		for (Kit kit : KitHandler.getAllKitsFromConfig()) {
			if (e.getWindow() != null) {
				if (e.getWindow() instanceof FormWindowSimple) {
					FormWindowSimple gui = (FormWindowSimple) e.getWindow();
					if (gui != null) {
						if (gui.getTitle().equals(StringUtils.translateColors("&9&lParadox Kits"))) {
							if (gui.getResponse().getClickedButton().getText() != null) {
								String responseName = gui.getResponse().getClickedButton().getText();
								if (responseName != null) {

									if (responseName.contains(kit.getName())) {
										if (p.hasPermission("paradox.kits." + kit.getName())) {
											if (p.hasPermission("paradox.admin") || !players
													.exists("Players." + p.getName() + ".cooldown." + kit.getName())) {
												p.removeAllWindows();
												p.showFormWindow(FormStorage.kitGet(kit));
												int secs = kit.getCoolDownInSeconds();
												players.set("Players." + p.getName() + ".cooldown." + kit.getName(),
														secs);
												players.save(playersFile);
												break;
											} else {

												p.removeAllWindows();
												p.sendMessage(StringUtils.getPrefix()
														+ "Kit on cooldown. Time remaining: "
														+ format(Duration.ofSeconds(players.getLong("Players."
																+ p.getName() + ".cooldown." + kit.getName()))));
											}
										} else {
											p.removeAllWindows();
											p.sendMessage(StringUtils.getPrefix() + "No permission for that kit.");
										}
										break;
									}
								}
							}
						} else if (gui.getTitle().equals(StringUtils.translateColors("&9&l") + kit.getName())) {
							if (gui.getResponse().getClickedButton().getText() != null) {
								String responseName = gui.getResponse().getClickedButton().getText();
								if (responseName != null) {
									if (responseName.equals(StringUtils.translateColors("&aAccept!"))) {
										kit.giveKitToPlayer(p);
										p.removeAllWindows();
										p.sendMessage(StringUtils.getPrefix() + "Redeemed kit " + kit.getName() + ".");
										break;
									} else {
										p.sendMessage(StringUtils.getPrefix() + "You chose to deny the kit.");
										break;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	protected static String format(Duration duration) {
		long hours = duration.toHours();
		long mins = duration.minusHours(hours).toMinutes();
		return String.format("%02d hours : %02d minutes", hours, mins);
	}
}
