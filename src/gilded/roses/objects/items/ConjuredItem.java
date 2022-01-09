package gilded.roses.objects.items;

public class ConjuredItem extends Item {
	
	public ConjuredItem(String name, short sellIn, short quality, double value) {
		super.setName(name);
		super.setSellIn((sellIn >= 0 ? sellIn : 0));
		super.setQuality((quality >= Item.MIN_QUALITY ? (quality <= Item.MAX_QUALITY ? quality : Item.MAX_QUALITY) : Item.MIN_QUALITY));
		super.setType(Item.TYPE_SIMPLE);
		super.setValue(value);
	}
	
	@Override
	public void newDay() {
		if (super.getSellIn() > 0) {
			super.decreaseSellin(DECREASE_VALUE);
			super.decreaseQuality((short) (DECREASE_VALUE*2));
		} else
			super.decreaseQuality((short) (DECREASE_VALUE*4));
	}
	
}
