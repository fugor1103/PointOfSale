import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.ConcreteIceCream;
import Model.ConcreteIceCreamDecorator;
import Model.IceCream;
import Model.IceCreamDecorator;


public class PointOfSaleController {
	private PointOfSaleWindow posWindow;
	private AdminDialog adminDialog;
	
	private IceCream iceCream;
	
	public static void main(String[] args) {
		new PointOfSaleController();
	}
	
	public PointOfSaleController(){
		this.posWindow = new PointOfSaleWindow();
		this.adminDialog = new AdminDialog(posWindow);
		
		this.posWindow.newIceCreamButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
//				posWindow.setTotalPrice(0.0);
				posWindow.addTotal(0.0,"");
				iceCream = null;
				for (int i = 0; i< posWindow.iceCreamButtonList.size(); i++){
					posWindow.iceCreamButtonList.get(i).setEnabled(true);
		    	}
			}

		});
		this.posWindow.systemAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminDialog.show();
			}
		});
		
		this.adminDialog.getAddFlavorButton().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
//            	posWindow.setTotalPrice(0.0);
				posWindow.addTotal(0.0,"");
				iceCream = null;
            	posWindow.updateMenu("flavor", adminDialog.getNameTF().getText() ,adminDialog.getPriceTF().getText());
            	updateButtonsListener();
            	adminDialog.hide();
            }

        });
		this.adminDialog.getAddDecoratorButton().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
//            	posWindow.setTotalPrice(0.0);
				posWindow.addTotal(0.0,"");
				iceCream = null;
            	posWindow.updateMenu("decorator", adminDialog.getNameTF().getText(), adminDialog.getPriceTF().getText());
            	updateButtonsListener();
            	adminDialog.hide();
            }

        });
		
		updateButtonsListener();
	}

	public void makeIceCream(IceCream addIceCream){
		if (addIceCream instanceof IceCreamDecorator){
			if(iceCream !=null)
				this.iceCream = new ConcreteIceCreamDecorator(this.iceCream.getDescription()+ " with " +addIceCream.getDescription(), this.iceCream.getCost()+ addIceCream.getCost());
			else
				this.iceCream = new ConcreteIceCreamDecorator(" with" +addIceCream.getDescription(), addIceCream.getCost());
				
			System.out.println("CurrentIceCream" + iceCream.getDescription() + iceCream.getCost());
			posWindow.addTotal(iceCream.getCost(),iceCream.getDescription());
		}
		else{
			if (iceCream == null)
				this.iceCream = new ConcreteIceCream(addIceCream.getDescription(), addIceCream.getCost());	
			else
				this.iceCream = new ConcreteIceCream(addIceCream.getDescription() +this.iceCream.getDescription(), this.iceCream.getCost()+addIceCream.getCost());	
				
			System.out.println("CurrentIceCream" + iceCream.getDescription() + iceCream.getCost());
			posWindow.addTotal(iceCream.getCost(),iceCream.getDescription());
		}
	}
	
	public double getCost(){
		return iceCream.getCost();
	}
	
	public void updateButtonsListener(){
		for (int i =0; i<this.posWindow.iceCreamButtonList.size(); i++){
			final IceCream iceCreamClicked =  posWindow.iceCreamButtonList.get(i).getIceCream();
			if (posWindow.iceCreamButtonList.get(i).getActionListeners().length !=0)
				posWindow.iceCreamButtonList.get(i).removeActionListener(posWindow.iceCreamButtonList.get(i).getActionListeners()[0]);
			posWindow.iceCreamButtonList.get(i).addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
//	            	posWindow.addTotal(posWindow.iceCreamButtonList.get(i).getPrice());
	            	makeIceCream(iceCreamClicked);
	            	posWindow.disableIceCreamButtons();
	            }

	        });
		}
		
		for (int i =0; i<this.posWindow.decoratorButtonList.size(); i++){
			final IceCream iceCreamClicked =  posWindow.decoratorButtonList.get(i).getIceCream();
			if (posWindow.decoratorButtonList.get(i).getActionListeners().length !=0)
				posWindow.decoratorButtonList.get(i).removeActionListener(posWindow.decoratorButtonList.get(i).getActionListeners()[0]);
			
			posWindow.decoratorButtonList.get(i).addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
//	            	posWindow.addTotal(posWindow.iceCreamButtonList.get(i).getPrice());
	            	makeIceCream(iceCreamClicked);
	            }

	        });
		}
	}
}
