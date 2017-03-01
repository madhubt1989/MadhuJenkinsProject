package javaPratice;

  class AbstractionPractice {
	
	  public static void main(String args[]){
		 	
//			 Bike ab = new Honda();
//			 ab.run();
		  
		  //Bike b = new Bike();
		  
		  Honda h = new Honda();
		  h.run();
		  
		 }

}

  abstract class Bike{
	  abstract void run();
  }
  
  class Honda extends Bike{

	
	void run() {
		
		System.out.println("abstract method implemented");
		
	}
	 
  }