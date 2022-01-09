package gilded.roses.inventory;

import java.util.ArrayList;
import java.util.HashMap;

import gilded.roses.inventory.repositories.ItemRepository;
import gilded.roses.objects.items.ConjuredItem;
import gilded.roses.objects.items.GrowingItem;
import gilded.roses.objects.items.Item;
import gilded.roses.objects.items.LegendaryItem;
import gilded.roses.objects.items.LimitedItem;
import gilded.roses.objects.items.RelicItem;
import gilded.roses.objects.items.SimpleItem;

public class InventoryInteractor implements InventoryUpdater, InventoryViewer {
	
	private ItemRepository repository = new ItemRepository();

	public InventoryInteractor() {
		createItems();
	}
	
	private void createItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new GrowingItem("MonItemGrowing", (short)10, (short)2, 10.0));
		items.add(new SimpleItem("MonItemSimple", (short)5, (short)2, 25.0));
		items.add(new LegendaryItem("MonItemLegendaire", 15.0));
		items.add(new LimitedItem("Limited", (short)10, (short)2, 5.0));
		items.add(new ConjuredItem("Conjured", (short)10, (short)2, 7.0));
		items.add(new RelicItem("Relic", (short)2, 10.0));
		repository.SaveInventory(items);
	}
	
	@Override
	public void removeItem(Item itemToRemove) {
		if (itemToRemove != null && repository.GetInventory().contains(itemToRemove)) {
			ArrayList<Item> items = repository.GetInventory();
			items.remove(itemToRemove);
			repository.SaveInventory(items);
		}
	}
	
	@Override
	public void addItem(Item itemToAdd) {
		if (itemToAdd != null) {
			ArrayList<Item> items = repository.GetInventory();
			items.add(itemToAdd);
			repository.SaveInventory(items);
		}
	}
	
	@Override
	public ArrayList<Item> GetInventory() {
		return repository.GetInventory();
	}
	
	@Override
	public HashMap<String, ArrayList<Item>> getInventoryByQuantity() {
		return mapItemsByQuantity(repository.GetInventory());
	}
	
	private HashMap<String, ArrayList<Item>> mapItemsByQuantity(ArrayList<Item> items) {
		HashMap<String, ArrayList<Item>> map = new HashMap<String, ArrayList<Item>>();
		
		if (!items.isEmpty()) {
			map.put(Item.TYPE_SIMPLE, getSimpleItems(items));
			map.put(Item.TYPE_GROWING, getGrowingItems(items));
			map.put(Item.TYPE_LIMITED, getLimitedItems(items));
			map.put(Item.TYPE_LEGENDARY, getLegendaryItems(items));
			map.put(Item.TYPE_CONJURED, getConjuredItems(items));
			map.put(Item.TYPE_RELIC, getRelicItems(items));
		} else {
			map.put(Item.TYPE_SIMPLE, null);
			map.put(Item.TYPE_GROWING, null);
			map.put(Item.TYPE_LIMITED, null);
			map.put(Item.TYPE_LEGENDARY, null);
			map.put(Item.TYPE_CONJURED, null);
			map.put(Item.TYPE_RELIC, null);
		}
		
		return map;
	}

	private ArrayList<Item> getLegendaryItems(ArrayList<Item> items) {
		ArrayList<Item> itemToReturn = new ArrayList<Item>();
		for (Item i : items) {
			if (i instanceof LegendaryItem)
				itemToReturn.add(i);
		}
		return itemToReturn;
	}

	private ArrayList<Item> getLimitedItems(ArrayList<Item> items) {
		ArrayList<Item> itemToReturn = new ArrayList<Item>();
		for (Item i : items) {
			if (i instanceof LimitedItem)
				itemToReturn.add(i);
		}
		return itemToReturn;
	}

	private ArrayList<Item> getGrowingItems(ArrayList<Item> items) {
		ArrayList<Item> itemToReturn = new ArrayList<Item>();
		for (Item i : items) {
			if (i instanceof GrowingItem)
				itemToReturn.add(i);
		}
		return itemToReturn;
	}

	private ArrayList<Item> getSimpleItems(ArrayList<Item> items) {
		ArrayList<Item> itemToReturn = new ArrayList<Item>();
		for (Item i : items) {
			if (i instanceof SimpleItem)
				itemToReturn.add(i);
		}
		return itemToReturn;
	}
	
	private ArrayList<Item> getConjuredItems(ArrayList<Item> items) {
		ArrayList<Item> itemToReturn = new ArrayList<Item>();
		for (Item i : items) {
			if (i instanceof ConjuredItem)
				itemToReturn.add(i);
		}
		return itemToReturn;
	}
	
	private ArrayList<Item> getRelicItems(ArrayList<Item> items) {
		ArrayList<Item> itemToReturn = new ArrayList<Item>();
		for (Item i : items) {
			if (i instanceof RelicItem)
				itemToReturn.add(i);
		}
		return itemToReturn;
	}

	@Override
	public void UpdateInventory() {
		ArrayList<Item> items = GetInventory();
		if (!items.isEmpty()) {
			for (Item i : items)
				i.newDay();
		}
		repository.SaveInventory(items);
	}
	
	
	
}
