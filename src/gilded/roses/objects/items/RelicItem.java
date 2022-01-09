package gilded.roses.objects.items;

public class RelicItem extends Item {
	
	public RelicItem(String name, short quality, double value) {
		super.setName(name);
		super.setSellIn((short)-1);
		super.setQuality((quality >= Item.MIN_QUALITY ? (quality <= Item.MAX_QUALITY ? quality : Item.MAX_QUALITY) : Item.MIN_QUALITY));
		super.setType(Item.TYPE_RELIC);
		super.setValue(value);
	}
	
	@Override
	public void newDay() {
		short nextQuality = (short) (super.getQuality() + (super.getQuality()*0.05));
		if (nextQuality < Item.MAX_RELIC_QUALITY)
			super.setQuality(nextQuality);
		else
			super.setQuality(MAX_RELIC_QUALITY);
	}
	
}
