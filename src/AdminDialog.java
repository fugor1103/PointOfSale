import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminDialog extends JDialog {
public static final long serialVersionUID=138938123;

private PointOfSaleWindow pos;
private JTextField nameTF;
private JTextField priceTF;
private JButton addFlavorButton;
private JButton addDecoratorButton;


public AdminDialog(PointOfSaleWindow pointOfSaleWindow) {
		super();
		this.pos = pointOfSaleWindow;
		
		JPanel panel = new JPanel(new GridLayout(1,4));
		nameTF = new JTextField("Name");
		nameTF.setSize(200, 100);
		priceTF = new JTextField("0.0");
		priceTF.setSize(200, 100);
		
		addFlavorButton = new JButton("Add Flavor");
		addFlavorButton.setSize(100, 100);
//		addFlavorButton.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//            	pos.updateMenu("flavor", nameTF.getText(), priceTF.getText());
//            }
//
//        });
		addDecoratorButton = new JButton("Add Decorator");
		addDecoratorButton.setSize(100, 100);
//		addDecoratorButton.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//            	pos.updateMenu("decorator", nameTF.getText(), priceTF.getText());
//            	
//            }
//
//        });
		
		panel.add(nameTF);
		panel.add(priceTF);
		panel.add(addFlavorButton);
		panel.add(addDecoratorButton);
		this.add(panel);
		this.setTitle("Admin");
		
        this.setSize(600, 100);
        this.setLocation(200, 200);
        this.setModal(true);
        this.setVisible(false);
}


public PointOfSaleWindow getPos() {
	return pos;
}


public void setPos(PointOfSaleWindow pos) {
	this.pos = pos;
}


public JTextField getNameTF() {
	return nameTF;
}


public void setNameTF(JTextField nameTF) {
	this.nameTF = nameTF;
}


public JTextField getPriceTF() {
	return priceTF;
}


public void setPriceTF(JTextField priceTF) {
	this.priceTF = priceTF;
}


public JButton getAddFlavorButton() {
	return addFlavorButton;
}


public void setAddFlavorButton(JButton addFlavorButton) {
	this.addFlavorButton = addFlavorButton;
}


public JButton getAddDecoratorButton() {
	return addDecoratorButton;
}


public void setAddDecoratorButton(JButton addDecoratorButton) {
	this.addDecoratorButton = addDecoratorButton;
}

		

}