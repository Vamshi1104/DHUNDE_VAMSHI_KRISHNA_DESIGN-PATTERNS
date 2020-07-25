package epam.task.DesignPatterns;

interface Cars extends Cloneable
{
	Cars makeCopy();
}
class Porsche implements Cars
{
    Porsche()
    {
    	System.out.println("Porsche is made");
    }
	@Override
	public Cars makeCopy() {
		System.out.println("Porsche Copy is being made");
		Porsche obj=null;
		try {
			obj=(Porsche)super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		System.out.println("Porsche copy is made");
		return obj;
		
	}
	
}

class cloneFactory
{
	Cars getClone(Cars car)
	{
		return car.makeCopy();
	}
}
public class Prototype {
	
	public static void main(String[] args)
	{
		cloneFactory carMaker=new cloneFactory();
		Porsche porsche=new Porsche();
		Porsche cloneporsche=(Porsche)(carMaker.getClone(porsche));
		
	}
}
