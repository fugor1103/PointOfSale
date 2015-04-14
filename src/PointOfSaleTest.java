import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import Model.ConcreteIceCream;
import Model.ConcreteIceCreamDecorator;


public class PointOfSaleTest extends TestCase{
	private PointOfSaleController posC;
	
	public void setUp() throws Exception {
		posC = new PointOfSaleController();
	}
	

	public void test() {
		ConcreteIceCream dummyIceCream = new ConcreteIceCream("Chocolate", 20.0);
		
		posC.makeIceCream(dummyIceCream);
		
		Double expected = 20.0;
		assertEquals(expected , posC.getCost());
		
		ConcreteIceCreamDecorator dummyIceCreamDecorator = new ConcreteIceCreamDecorator("Strawberry", 5.0);
		
		posC.makeIceCream(dummyIceCreamDecorator);
		
		expected = 25.0;
		assertEquals(expected , posC.getCost());
	
		
	}

}
