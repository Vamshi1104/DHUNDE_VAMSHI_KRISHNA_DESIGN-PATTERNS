package epam.task.DesignPatterns;
interface Chain {

	public void setNextChain(Chain nextChain);
	public void calculate(Numbers request);
	
}
class Numbers {

	private int num1;
	private int num2;
	
	private String Caltype;
	
	public Numbers(int num1, int num2, String calctype){
		
		this.num1=num1;
		this.num2=num2;
		this.Caltype=calctype;
		
	}
	
	public int getNumber1(){ return num1; }
	public int getNumber2(){ return num2; }
	public String getCalcWanted(){ return Caltype; }
	
}
class AddNumbers implements Chain{

	private  Chain next;
	
	public void setNextChain(Chain next) {
		
		this.next = next;
		
	}

	public void calculate(Numbers request) {
		
		if(request.getCalcWanted() == "add"){
			
			System.out.print(request.getNumber1() + " + " + request.getNumber2() + " = "+
					(request.getNumber1()+request.getNumber2()));
			
		} else {
			
			next.calculate(request);
			
		}
		
	}
}
 class SubtractNumbers implements Chain{

	private  Chain next;
	
	@Override
	public void setNextChain(Chain next) {
		
		this.next = next;
		
	}

	@Override
	public void calculate(Numbers request) {
		
		if(request.getCalcWanted() == "sub"){
			
			System.out.print(request.getNumber1() + " - " + request.getNumber2() + " = "+
					(request.getNumber1()-request.getNumber2()));
			
		} else {
			
			next.calculate(request);
			
		}
		
	}

	
	
}
class MultNumbers implements Chain{

	private  Chain next;
	
	@Override
	public void setNextChain(Chain next) {
		
		this.next = next;
		
	}

	@Override
	public void calculate(Numbers request) {
		
		if(request.getCalcWanted() == "mult"){
			
			System.out.print(request.getNumber1() + " * " + request.getNumber2() + " = "+
					(request.getNumber1()*request.getNumber2()));
			
		} else {
			
			next.calculate(request);
			
		}
		
	}

	
	
}

class DivideNumbers implements Chain{

	private  Chain next;
	
	@Override
	public void setNextChain(Chain next) {
		
		this.next = next;
		
	}

	@Override
	public void calculate(Numbers request) {
		
		if(request.getCalcWanted() == "div"){
			
			System.out.print(request.getNumber1() + " / " + request.getNumber2() + " = "+
					(request.getNumber1()/request.getNumber2()));
			
		} else {
			
			System.out.print("Only works for add, sub, mult, and div");
			
		}
	}
}
public class ChainPattern {
	
	public static void main(String[] args){

		
		Chain chainCalc1 = new AddNumbers();
		Chain chainCalc2 = new SubtractNumbers();
		Chain chainCalc3 = new MultNumbers();
		Chain chainCalc4 = new DivideNumbers();
		

		chainCalc1.setNextChain(chainCalc2);
		chainCalc2.setNextChain(chainCalc3);
		chainCalc3.setNextChain(chainCalc4);

		
		Numbers request = new Numbers(5,1,"sub");
		
		chainCalc1.calculate(request);
		
	}

}

