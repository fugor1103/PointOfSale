package Model;

public class ConcreteIceCream extends IceCream{
	private double cost;
	
	public ConcreteIceCream(String desc, Double cst){
		description = desc;
		cost = cst;
	}
	
	@Override
	public Double getCost() {
		return cost;
	}

}
