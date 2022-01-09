package gilded.roses.objects.shops.events;

import gilded.roses.objects.items.Item;

public class SoldItemEvent {
	
	private Item item;
	
	public SoldItemEvent(Item item) {
		this.setItem(item);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
