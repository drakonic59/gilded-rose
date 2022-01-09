package gilded.roses.objects.items;

public class LegendaryItem extends Item {
	
	public LegendaryItem(String name, double value) {
		super.setName(name);
		super.setQuality(LEGENDARY_ITEM_QUALITY);
		super.setSellIn(LEGENDARY_ITEM_SELLIN);
		super.setType(Item.TYPE_LEGENDARY);
		super.setValue(value);
	}
	
	@Override
	public void newDay() {
		return;
	}

}
