package epam.task.DesignPatterns;
 interface Burger
 {
	
	 public String getDescription();
	 public double getCost();
}
 class PlainBurger implements Burger {
	 
	public String getDescription() {
		
		return "Basic Burger";
	
	}

	 public double getCost() {

		System.out.println("Cost of Bread: " + 5.00);
		
		return 5.00;
	
	}
 
}
abstract class ToppingDecorator implements Burger {

	Burger burg;
	
	ToppingDecorator(Burger burg){
		
		this.burg=burg;
		
	}
	
	 public String getDescription() {
		
		return burg.getDescription();
		
	}

	 public double getCost() {
		
		return burg.getCost();
		
	}
	
}
class Mayonnaise  extends ToppingDecorator {

	 Mayonnaise(Burger burg) {
		
		super(burg);
		
		System.out.println("Adding Mayo");
	}
	
	public String getDescription(){
		
		return burg.getDescription() + ", mayonnaise";
		
	}
	
	 public double getCost(){
		
		System.out.println("Cost of Moz: " + .50);
		
		return burg.getCost() + .50;
		
	}
	
}
class Chicken  extends ToppingDecorator {

	 Chicken(Burger burg) {
		
		super(burg);
		
		System.out.println("Adding Chicken");
	}
	
	public String getDescription(){
		
		return burg.getDescription() + ", chicken";
		
	}
	
	 public double getCost(){
		
		System.out.println("Cost of Chicken: " + 10.50);
		
		return burg.getCost() + 10.50;
		
	}
	
}
class Sauce  extends ToppingDecorator {

	 Sauce(Burger burg) {
		
		super(burg);
		
		System.out.println("Adding Sauce");
	}
	
	public String getDescription(){
		
		return burg.getDescription() + ", Sauce";
		
	}
	
	 public double getCost(){
		
		System.out.println("Cost of Sauce: " + .50);
		
		return burg.getCost() + .50;
		
	}
	
}
public class Decorator {

	public static void main(String[] args)
	{
		Burger burg=new Sauce(new Chicken(new Mayonnaise(new PlainBurger())));
		System.out.println("Burger Description: "+burg.getDescription());
		System.out.println("Burger Cost: "+burg.getCost());
	}
}
