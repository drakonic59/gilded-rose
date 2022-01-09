package gilded.roses.objects.items;

public class LimitedItem extends Item {
	
	public LimitedItem(String name, short sellIn, short quality, double value) {
		super.setName(name);
		super.setSellIn((sellIn >= 0 ? sellIn : 0));
		super.setQuality((quality >= Item.MIN_QUALITY ? (quality <= Item.MAX_QUALITY ? quality : Item.MAX_QUALITY) : Item.MIN_QUALITY));
		super.setType(Item.TYPE_LIMITED);
		super.setValue(value);
	}
	
	@Override
	public void newDay() {
		if (super.getSellIn() > 0) {
			
			super.decreaseSellin(DECREASE_VALUE);
			
			if (super.getSellIn() > 10)
				super.increaseQuality(INCREASE_VALUE);
			else if (super.getSellIn() > 5)
				super.increaseQuality((short) (INCREASE_VALUE*2));
			else
				super.increaseQuality((short) (INCREASE_VALUE*3));
			
		} else
			super.setQuality((short) 0);
	}

}
