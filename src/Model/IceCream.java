package Model;

public abstract class IceCream {
	protected String description;
	private Double cost;
	
	public String getDescription() {
		return description;
	}
	public abstract Double getCost();
	
	
}
