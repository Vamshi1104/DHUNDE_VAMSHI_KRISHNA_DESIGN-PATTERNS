package epam.task.DesignPatterns;
interface JPEG
{
	public void display();
}
interface PNG
{
	public void display();
}
class JPEGDisplayer implements JPEG
{
	String type;
	JPEGDisplayer(String type)
	{
		this.type=type;
	}
	public void display()
	{
		if(type.equals("JPEG"))
			System.out.println("Image as JPEG is being displayed");
		else
			System.out.println("Type not supported");
	}
}
class PNGDisplayer implements PNG
{
	String type;
	PNGDisplayer(String type)
	{
		this.type=type;
	}
	public void display()
	{
		if(type.equals("PNG"))
			System.out.println("Image as PNG being displayed");
		else
			System.out.println("Type not supported");
	}
}
class PNGToJPEGAdaptor implements PNG
{
	public void display()
	{
		JPEG J=new JPEGDisplayer("JPEG");
		J.display();
	}
}
class Adaptor
{
	public static void main(String[] args)
	{
		JPEG J=new JPEGDisplayer("PNG");
		J.display(); //Error pops up as not supported
		PNGToJPEGAdaptor ad=new PNGToJPEGAdaptor(); //Adaptor
		ad.display(); //Successful display
		
	}
}





