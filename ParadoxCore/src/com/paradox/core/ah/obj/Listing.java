package com.paradox.core.ah.obj;

import java.util.UUID;

import cn.nukkit.item.Item;

public class Listing {

	private Item item;
	private int pricing;
	private UUID sellerUUID;

	public Listing(Item item, int pricing, UUID sellerUUID) {
		super();
		this.item = item;
		this.pricing = pricing;
		this.sellerUUID = sellerUUID;
	}

	public Item getItem() {
		return item;
	}

	public int getPricing() {
		return pricing;
	}

	public UUID getSellerUUID() {
		return sellerUUID;
	}

}
