package gilded.roses.inventory;

import java.util.ArrayList;
import java.util.HashMap;

import gilded.roses.objects.items.Item;

public interface InventoryViewer {
	
	public ArrayList<Item> GetInventory();
	public HashMap<String, ArrayList<Item>> getInventoryByQuantity();
	
}
