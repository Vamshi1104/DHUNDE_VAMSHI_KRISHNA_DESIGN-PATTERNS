package epam.task.DesignPatterns;
interface LaptopState
{ 
    public void alert(CurrentState state); 
} 
  
class CurrentState 
{ 
    private LaptopState state;
  
    public CurrentState()  
    { 
        state = new ShutDown();
    } 
  
    public void setState(LaptopState state)  
    { 
         this.state=state;
    } 
  
    public void alert()  
    { 
        state.alert(this);
    } 
} 
  
class ShutDown implements LaptopState  
{ 
    @Override
    public void alert(CurrentState state)  
    { 
         System.out.println("shut down..."); 
    } 
  
} 
  
class Sleep implements LaptopState  
{ 
    @Override
    public void alert(CurrentState state)  
    { 
         System.out.println("Sleep..."); 
    } 
  
} 
class Running implements LaptopState  
{ 
    @Override
    public void alert(CurrentState state)  
    { 
         System.out.println("Running..."); 
    } 
  
} 
  
class State 
{ 
    public static void main(String[] args)  
    { 
        CurrentState state=new CurrentState();
        state.alert();
        state.setState(new Running());
        state.alert();
        state.setState(new Sleep());
        state.alert();
        state.setState(new ShutDown());
        state.alert();

        
    } 
} 

