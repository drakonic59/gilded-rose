package gilded.roses.objects.items;

public abstract class Item {
	
	public static final String TYPE_GROWING = "GROWING_ITEM";
	public static final String TYPE_LEGENDARY = "LEGENDARY_ITEM";
	public static final String TYPE_LIMITED = "LIMITED_ITEM";
	public static final String TYPE_SIMPLE = "SIMPLE_ITEM";
	public static final String TYPE_CONJURED = "CONJURED_ITEM";
	public static final String TYPE_RELIC = "RELIC_ITEM";
	
	public static final short DECREASE_VALUE = 1;
	public static final short INCREASE_VALUE = 1;
	public static final short MAX_QUALITY = 50;
	public static final short MIN_QUALITY = 0;
	public static final short MAX_RELIC_QUALITY = 100;
	
	public static final short LEGENDARY_ITEM_QUALITY = 80;
	public static final short LEGENDARY_ITEM_SELLIN = -1;
	
	private String name;
	private String type;
	private short sellIn;
	private short quality;
	private double value;
	
	protected void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	protected void setName(String nam) {
		name = nam;
	}
	
	public String getName() {
		return name;
	}
	
	protected void setSellIn(short sellin) {
		sellIn = sellin;
	}
	
	public short getSellIn() {
		return sellIn;
	}
	
	protected void setQuality(short qualiti) {
		quality = qualiti;
	}
	
	public short getQuality() {
		return quality;
	}
	
	public abstract void newDay();
	
	public void decreaseQuality(short DECREASE) {
		setQuality((short) (getQuality() - DECREASE >= 0 ? 
				getQuality()-DECREASE
				:
				0));
	}
	
	public void decreaseSellin(short DECREASE) {
		setSellIn((short) (getSellIn()-DECREASE));
	}
	
	public void increaseQuality(short INCREASE) {
		setQuality((short) (getQuality() + INCREASE <= Item.MAX_QUALITY ? 
				getQuality()+Item.INCREASE_VALUE
				:
				Item.MAX_QUALITY));
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "    [" + getSellIn() + "] " + getName() + " - Q: " + getQuality() + " - V: " + getValue();
	}
}
