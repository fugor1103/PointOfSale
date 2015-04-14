import javax.swing.*;

import Model.ConcreteIceCream;
import Model.ConcreteIceCreamDecorator;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;




public class PointOfSaleWindow extends JFrame {
	public static final long serialVersionUID=138938122;
	public JLabel totalLabel
	;public JLabel icecreamLabel;
	public AdminDialog adminDialog;
	public ArrayList <IceCreamButton> iceCreamButtonList;
	public ArrayList <DecoratorButton> decoratorButtonList;
	public JButton systemAdminButton = new JButton("System Administrator");
	public JPanel mainPanel;
	public JLabel flavorLabel = new JLabel("ICE-CREAM Flavor");
	public JLabel decoratorLabel = new JLabel("Decorator");
	public JButton newIceCreamButton = new JButton("New Ice Cream");;
	
	public JLabel getTotalLabel() {
		return totalLabel;
	}

	public JLabel getIcecreamLabel() {
		return icecreamLabel;
	}

	public void setIcecreamLabel(JLabel icecreamLabel) {
		this.icecreamLabel = icecreamLabel;
	}

	public void setTotalLabel(JLabel totalLabel) {
		this.totalLabel = totalLabel;
	}

	public PointOfSaleWindow(){
		super("Point of Sale");
		getContentPane().setLayout(new BorderLayout(0,0));

		this.mainPanel=new JPanel(new GridLayout(5,3));
		//      First Row
		this.mainPanel.add(flavorLabel);
		this.mainPanel.add(decoratorLabel);
		this.mainPanel.add(newIceCreamButton);

		//      Second Row
		ConcreteIceCream chocolateIceCream = new ConcreteIceCream("Chocolate", 20.0);
		IceCreamButton chocolateIceCreamBtn = new IceCreamButton(chocolateIceCream, this);
		this.mainPanel.add(chocolateIceCreamBtn);
		ConcreteIceCreamDecorator mmDecorator = new ConcreteIceCreamDecorator("M&M", 5.0);
		DecoratorButton mmDecoratorBtn = new DecoratorButton(mmDecorator, this);
	
		this.mainPanel.add(mmDecoratorBtn);
		this.mainPanel.add(new JLabel(""));

		//      Third Row
		ConcreteIceCream vanillaIceCream = new ConcreteIceCream("Vanilla", 20.0);
		IceCreamButton vanillaIceCreamBtn = new IceCreamButton(vanillaIceCream, this);
		this.mainPanel.add(vanillaIceCreamBtn);
		ConcreteIceCreamDecorator strawberryDecorator = new ConcreteIceCreamDecorator("Strawberry", 5.0);
		DecoratorButton strawberryDecoratorBtn = new DecoratorButton(strawberryDecorator, this);
		
		this.mainPanel.add(strawberryDecoratorBtn);
		this.mainPanel.add(new JLabel(""));

		this.mainPanel.add(new JLabel(""));
		this.mainPanel.add(new JLabel(""));
		totalLabel = new JLabel("Total:");
		this.mainPanel.add(totalLabel);

		this.mainPanel.add(systemAdminButton);
		this.mainPanel.add(new JLabel(""));
		this.mainPanel.add(new JLabel(""));

		iceCreamButtonList = new ArrayList();
		iceCreamButtonList.add(chocolateIceCreamBtn);
		iceCreamButtonList.add(vanillaIceCreamBtn);

		decoratorButtonList = new ArrayList();
		decoratorButtonList.add(mmDecoratorBtn);
		decoratorButtonList.add(strawberryDecoratorBtn);

		icecreamLabel = new JLabel("");
		this.mainPanel.add(icecreamLabel);
		
		getContentPane().add(this.mainPanel, BorderLayout.CENTER);
		getContentPane().add(this.icecreamLabel, BorderLayout.SOUTH);
		this.setSize(500, 400);
		this.setLocation(100, 100);
		this.setVisible(true);
	}


	public void addTotal(Double price, String icecream){
		totalLabel.setText("Total: $" +price+"");
		icecreamLabel.setText(icecream);
	}

	public void updateMenu(String type, String name, String price){
		System.out.println(type + name + price);
		if (type.equals("flavor")){

			ConcreteIceCream newIceCream = new ConcreteIceCream(name,Double.parseDouble(price));
			IceCreamButton newIceCreamBtn = new IceCreamButton(newIceCream, this);
			iceCreamButtonList.add(newIceCreamBtn);
		}
		else{
			ConcreteIceCreamDecorator newIceCreamDecorator = new ConcreteIceCreamDecorator(name,Double.parseDouble(price));
			DecoratorButton newDecoratorButton = new DecoratorButton(newIceCreamDecorator, this);
			decoratorButtonList.add(newDecoratorButton);
		}

		System.out.println("IceCreamButtonListsize" + iceCreamButtonList.size());
		System.out.println("decoratorButtonListsize" + decoratorButtonList.size());

		updateScreen();
	}
    public void disableIceCreamButtons(){
    	for (int i = 0; i< iceCreamButtonList.size(); i++){
    		iceCreamButtonList.get(i).setEnabled(false);
    	}
    }
	public void updateScreen(){
		
		int numberOfRows = iceCreamButtonList.size();
		if (iceCreamButtonList.size() < decoratorButtonList.size()){
			numberOfRows = decoratorButtonList.size();
		}
		this.remove(this.mainPanel);
		
		this.mainPanel.invalidate();
		this.mainPanel.removeAll();
		this.mainPanel.invalidate();
		this.mainPanel.doLayout();
		
		this.mainPanel=new JPanel(new GridLayout(numberOfRows+3,3));
		System.out.println("mainPanel = new" +numberOfRows);
		//First Row
		this.mainPanel.add(this.flavorLabel);
		this.mainPanel.add(this.decoratorLabel);
		this.mainPanel.add(this.newIceCreamButton);
		
		//Second Row
		for (int i = 0; i < numberOfRows; i++){
			System.out.println(i);
			if (i+1 <= iceCreamButtonList.size()){
				System.out.println("add flavor" + iceCreamButtonList.get(i).getLabel() );
				this.mainPanel.add(iceCreamButtonList.get(i));
				iceCreamButtonList.get(i).setEnabled(true);
			}
			else
				this.mainPanel.add(new JLabel(""));
			if (i+1 <= decoratorButtonList.size()){
				System.out.println("add decorator" +decoratorButtonList.get(i).getLabel());
				this.mainPanel.add(decoratorButtonList.get(i));
				decoratorButtonList.get(i).setEnabled(true);
			}
			else
				this.mainPanel.add(new JLabel(""));
			
			this.mainPanel.add(new JLabel(""));
		}

		// second last Row
		this.mainPanel.add(new JLabel(""));
		this.mainPanel.add(new JLabel(""));
		this.mainPanel.add(this.totalLabel);
		
		//last row
		this.mainPanel.add(systemAdminButton);
		this.mainPanel.add(new JLabel(""));
		this.mainPanel.add(new JLabel(""));

		icecreamLabel = new JLabel("");
		this.mainPanel.add(icecreamLabel);

		this.add(mainPanel, BorderLayout.CENTER);
		this.add(icecreamLabel, BorderLayout.SOUTH);
		this.setSize(500, 500);
		this.setLocation(100, 100);
		this.setVisible(true);
		this.mainPanel.doLayout();
		}

}

