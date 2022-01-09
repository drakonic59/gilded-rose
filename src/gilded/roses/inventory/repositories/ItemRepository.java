package gilded.roses.inventory.repositories;

import java.util.ArrayList;

import gilded.roses.objects.items.Item;

public class ItemRepository {
	
	private static ArrayList<Item> items = new ArrayList<Item>();
	
	public ArrayList<Item> GetInventory() {
		return items;
	}
	
	public void SaveInventory(ArrayList<Item> items) {
		ItemRepository.items = items;
	}
	
}
