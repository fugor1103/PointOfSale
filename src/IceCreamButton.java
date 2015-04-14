
import javax.swing.*;

import Model.IceCream;

import java.awt.*;
import java.awt.event.*;

public class IceCreamButton extends JButton {

	private static final long serialVersionUID = 1L;

	private String name;
	private Double price;
	private PointOfSaleWindow pos;
	private IceCream iceCream;
	
	
	public IceCream getIceCream() {
		return iceCream;
	}

	public void setIceCream(IceCream iceCream) {
		this.iceCream = iceCream;
	}

	public IceCreamButton(IceCream iceCream, PointOfSaleWindow pointOfSale){
		this.iceCream = iceCream;
		this.name = iceCream.getDescription();
		this.price = iceCream.getCost();
		this.pos = pointOfSale;
		this.setLabel(name + ", $" + price);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public PointOfSaleWindow getPos() {
		return pos;
	}

	public void setPos(PointOfSaleWindow pos) {
		this.pos = pos;
	}
	
}
