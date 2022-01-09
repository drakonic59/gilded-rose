package gilded.roses.inventory;

import gilded.roses.objects.items.Item;

public interface InventoryUpdater {
	
	public void UpdateInventory();
	public void removeItem(Item itemToRemove);
	public void addItem(Item itemToAdd);
	
}
