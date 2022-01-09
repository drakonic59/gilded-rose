package gilded.roses.objects.shops;

import java.util.ArrayList;

import gilded.roses.inventory.InventoryInteractor;
import gilded.roses.inventory.InventoryUpdater;
import gilded.roses.inventory.InventoryViewer;
import gilded.roses.objects.items.Item;
import gilded.roses.objects.items.RelicItem;
import gilded.roses.objects.shops.events.SoldItemEvent;

public abstract class Shop {
	
	private double balance;
	
	private ArrayList<ShopListener> listeners = new ArrayList<ShopListener>();
	
	private static final InventoryInteractor interactor = new InventoryInteractor();
	
	private InventoryUpdater updater = (InventoryUpdater)interactor;
	private InventoryViewer viewer = (InventoryViewer)interactor;
	
	public InventoryViewer getViewer() {
		return viewer;
	}
	
	public void addListener(ShopListener listener) {
		listeners.add(listener);
	}
	
	public void updateItems() {
		for (Item i : viewer.GetInventory()) {
			if (i instanceof RelicItem)
				balance += (i.getQuality() / Item.MAX_RELIC_QUALITY) * i.getValue();
		}
		updater.UpdateInventory();
	}
	
	public InventoryUpdater getUpdater() {
		return updater;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double sellItem(Item toSell) {
		if (toSell != null && !(toSell instanceof RelicItem)) {
			balance += toSell.getValue();
			updater.removeItem(toSell);
			notifyListeners(new SoldItemEvent(toSell));
		}
		return balance;
	}
	
	private void notifyListeners(SoldItemEvent soldItemEvent) {
		for (ShopListener listener : listeners)
			listener.soldItem(soldItemEvent);
	}

	public double buyItem(Item toBuy) {
		if (toBuy != null) {
			balance -= toBuy.getValue();
			updater.addItem(toBuy);
		}
		return balance;
	}
	
	public Item transmuteItem(Item itemToTransmute) {
		if (itemToTransmute != null) {
			Transmuter.transmuteItem(itemToTransmute);
			balance += 100;
		}
		return itemToTransmute;
	}
	
}
