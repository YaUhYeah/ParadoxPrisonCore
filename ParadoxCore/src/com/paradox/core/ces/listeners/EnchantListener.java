package com.paradox.core.ces.listeners;

import java.util.HashMap;

import com.paradox.core.ces.enchants.EnchantHandler;
import com.paradox.core.ces.forms.FormStorage;
import com.paradox.core.ces.obj.CustomEnchant;
import com.paradox.core.ces.obj.EnchantType;
import com.paradox.core.ces.obj.TempCE;
import com.paradox.core.utils.CEUtils;
import com.paradox.core.utils.MineUtils;
import com.paradox.core.utils.NumberUtils;
import com.paradox.core.utils.StringUtils;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;

public class EnchantListener implements Listener {

	public static HashMap<Player, TempCE> costOfEnchantByPlayer = new HashMap<>();
	public static HashMap<Player, CustomEnchant> ceByPlayer = new HashMap<>();

	@EventHandler
	public void onResponse1(PlayerFormRespondedEvent e) {
		Player p = e.getPlayer();
		if (e.getWindow() != null) {
			if (e.getWindow() instanceof FormWindowSimple) {
				FormWindowSimple gui = (FormWindowSimple) e.getWindow();
				if (gui != null) {
					if (gui.getResponse().getClickedButton().getText() != null) {
						String responseName = gui.getResponse().getClickedButton().getText();
						if (responseName != null) {
							if (CEUtils.getCEByDisplayName(responseName) != null) {
								CustomEnchant ce = CEUtils.getCEByDisplayName(responseName);
								if (ce != null) {
									p.removeAllWindows();
									p.showFormWindow(FormStorage.ceMenu(p.getInventory().getItemInHand(), ce));
									ceByPlayer.put(p, ce);
									//
								}
							}
						}
					}
				}
			} else if (e.getWindow() instanceof FormWindowCustom) {
				FormWindowCustom gui = (FormWindowCustom) e.getWindow();
				if (gui != null) {
					if (e.getResponse() != null) {
						if (!costOfEnchantByPlayer.containsKey(p)) {
							if (gui.getResponse().getSliderResponse(1) != 0) {
								float lvl = gui.getResponse().getSliderResponse(1);
								p.removeAllWindows();
								p.showFormWindow(FormStorage.confirmMenu((int) lvl, ceByPlayer.get(p)));
								costOfEnchantByPlayer.put(p,
										new TempCE(ceByPlayer.get(p), (int) lvl,
												NumberUtils.getCostOfEnchantmentByLevel((int) lvl,
														ceByPlayer.get(p).getCostMultiplier())));
								ceByPlayer.remove(p);
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onResponse2(PlayerFormRespondedEvent e) {
		Player p = e.getPlayer();
		if (e.getWindow() != null) {
			if (e.getWindow() instanceof FormWindowSimple) {
				if (costOfEnchantByPlayer.containsKey(p)) {
					FormWindowSimple gui = (FormWindowSimple) e.getWindow();
					CustomEnchant ce = costOfEnchantByPlayer.get(p).getCe();
					if (gui != null) {
						String responseName = gui.getResponse().getClickedButton().getText();
						if (responseName != null) {
							if (responseName.contains("Accept")) {
								if (ce.getType().equals(EnchantType.CUSTOM)) {
									if (CEUtils.getLevelOfEnchantByDisplayName(ce.getDisplayNameOfEnchantment(),
											p.getInventory().getItemInHand()) < costOfEnchantByPlayer.get(p)
													.getLevel()) {
										p.sendMessage(StringUtils.translateColors(StringUtils.getPrefix()
												+ "The purchased ce was applied to your pickaxe!"));
										EnchantHandler.applyEnchantment(p, p.getInventory().getItemInHand(), ce,
												costOfEnchantByPlayer.get(p).getLevel());
										costOfEnchantByPlayer.remove(p);
									} else {
										p.sendMessage(StringUtils.getPrefix()
												+ "Your pickaxe already has that enchantment at that level or better.");
										costOfEnchantByPlayer.remove(p);
									}
								} else {
									if (ce.getDisplayNameOfEnchantment().contains("Unbreaking")) {
										Enchantment e1 = Enchantment.get(Enchantment.ID_DURABILITY);
										e1.setLevel(costOfEnchantByPlayer.get(p).getLevel(), false);
										if (CEUtils.containsEnchantment(p.getInventory().getItemInHand(), e1)) {
											if (CEUtils.isHigherEnchantLevel(p.getInventory().getItemInHand(), e1)) {
												EnchantHandler.applyEnchant(p, p.getInventory().getItemInHand(), e1,
														costOfEnchantByPlayer.get(p).getLevel());
												costOfEnchantByPlayer.remove(p);
											} else {
												p.sendMessage(StringUtils.getPrefix()
														+ "Your pickaxe already has that enchantment at that level or better.");
												costOfEnchantByPlayer.remove(p);
											}
										} else {
											EnchantHandler.applyEnchant(p, p.getInventory().getItemInHand(), e1,
													costOfEnchantByPlayer.get(p).getLevel());
											costOfEnchantByPlayer.remove(p);
										}
									} else if (ce.getDisplayNameOfEnchantment().contains("Efficiency")) {
										Enchantment e1 = Enchantment.get(Enchantment.ID_EFFICIENCY);
										e1.setLevel(costOfEnchantByPlayer.get(p).getLevel(), false);
										if (CEUtils.containsEnchantment(p.getInventory().getItemInHand(), e1)) {
											if (CEUtils.isHigherEnchantLevel(p.getInventory().getItemInHand(), e1)) {
												EnchantHandler.applyEnchant(p, p.getInventory().getItemInHand(), e1,
														costOfEnchantByPlayer.get(p).getLevel());
												costOfEnchantByPlayer.remove(p);
											} else {
												p.sendMessage(StringUtils.getPrefix()
														+ "Your pickaxe already has that enchantment at that level or better.");
												costOfEnchantByPlayer.remove(p);
											}
										} else {
											EnchantHandler.applyEnchant(p, p.getInventory().getItemInHand(), e1,
													costOfEnchantByPlayer.get(p).getLevel());
											costOfEnchantByPlayer.remove(p);
										}
									} else if (ce.getDisplayNameOfEnchantment().contains("Fortune")) {
										Enchantment e1 = Enchantment.get(Enchantment.ID_FORTUNE_DIGGING);
										e1.setLevel(costOfEnchantByPlayer.get(p).getLevel(), false);
										if (CEUtils.containsEnchantment(p.getInventory().getItemInHand(), e1)) {
											if (CEUtils.isHigherEnchantLevel(p.getInventory().getItemInHand(), e1)) {
												EnchantHandler.applyEnchant(p, p.getInventory().getItemInHand(), e1,
														costOfEnchantByPlayer.get(p).getLevel());
												costOfEnchantByPlayer.remove(p);
											} else {
												p.sendMessage(StringUtils.getPrefix()
														+ "Your pickaxe already has that enchantment at that level or better.");
												costOfEnchantByPlayer.remove(p);
											}
										} else {
											EnchantHandler.applyEnchant(p, p.getInventory().getItemInHand(), e1,
													costOfEnchantByPlayer.get(p).getLevel());
											costOfEnchantByPlayer.remove(p);
										}
									}
								}
							} else if (responseName.contains("Deny")) {
								p.sendMessage(StringUtils.translateColors(StringUtils.getPrefix()
										+ "Denied purchase of " + " " + ce.getDisplayNameOfEnchantment() + "&7!"));
								costOfEnchantByPlayer.remove(p);
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onMine(BlockBreakEvent e) {
		Item tool = e.getPlayer().getInventory().getItemInHand();
		if (CEUtils.containsEnchantment(tool, CEUtils.getCEByDisplayName(StringUtils.translateColors("&fMagnet")))) {
			if (MineUtils.isLocInMine(e.getBlock().getLocation())) {
				PlayerInventory inventoryAutoAdd = e.getPlayer().getInventory();
				Item[] itemsToAdd = e.getDrops();
				if (!e.isCancelled()) {
					inventoryAutoAdd.addItem(itemsToAdd);
				}
				Item[] dropsNull = { new Item(0) };
				e.setDrops(dropsNull);
			}
		}
	}
}
