package gilded.roses.objects.shops;

import gilded.roses.objects.shops.events.SoldItemEvent;

public interface ShopListener {
	
	public void soldItem(SoldItemEvent event);
	
}
