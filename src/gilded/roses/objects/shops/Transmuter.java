package gilded.roses.objects.shops;

import gilded.roses.objects.items.Item;
import gilded.roses.objects.items.RelicItem;

public class Transmuter {
	
	public static Item transmuteItem(Item itemToTransmute) {
		if (itemToTransmute instanceof RelicItem)
			return transmuteRelic(itemToTransmute);
		else
			return transmute(itemToTransmute);
	}

	private static Item transmute(Item itemToTransmute) {
		if (itemToTransmute != null)
			itemToTransmute.decreaseQuality((short)10);
		return itemToTransmute;
	}

	private static Item transmuteRelic(Item itemToTransmute) {
		if (itemToTransmute != null)
			itemToTransmute.decreaseQuality((short)10);
		return itemToTransmute;
	}
	
}
