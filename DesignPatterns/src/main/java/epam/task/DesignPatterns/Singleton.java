package epam.task.DesignPatterns;
public class Singleton {
	private static Singleton obj; 
	  
	private Singleton() {} 
  
    public static synchronized Singleton getInstance() 
    { 
        if (obj==null) 
            obj = new Singleton(); 
        return obj; 
    } 
    public static void main(String[] args)
    {
    	Singleton obj1=Singleton.getInstance();
    	Singleton obj2=Singleton.getInstance(); //Can't create another one returns previous obj
    	System.out.println(obj1==obj2); //Returns true i.e both references are pointing to same obj
    }

}

