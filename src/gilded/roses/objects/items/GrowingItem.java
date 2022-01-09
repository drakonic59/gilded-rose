package gilded.roses.objects.items;

public class GrowingItem extends Item {
	
	public GrowingItem(String name, short sellIn, short quality, double value) {
		super.setName(name);
		super.setSellIn((sellIn >= 0 ? sellIn : 0));
		super.setQuality((quality >= Item.MIN_QUALITY ? (quality <= Item.MAX_QUALITY ? quality : Item.MAX_QUALITY) : Item.MIN_QUALITY));
		super.setType(Item.TYPE_GROWING);
		super.setValue(value);
	}
	
	@Override
	public void newDay() {
		if (super.getSellIn() > 0)
			super.decreaseSellin(DECREASE_VALUE);
		super.increaseQuality(INCREASE_VALUE);
	}

}
