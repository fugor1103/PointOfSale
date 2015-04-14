package Model;

public class ConcreteIceCreamDecorator extends IceCreamDecorator{
	private String description;
	private Double cost;
	
	
	public ConcreteIceCreamDecorator(String desc, Double cst){
		this.description = desc;
		this.cost = cst;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Double getCost(){
		return cost; 
	}
}
