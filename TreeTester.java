import java.io.IOException;
import bridges.connect.Bridges;
import bridges.validation.RateLimitException;

/**
   This program tests the binary search tree class.
*/
public class TreeTester { 

	
   public static void main(String[] args) {  
      BSTNode<String,Person> BSTRoot = new BSTNode<String,Person>("Megan",new Person());
      BSTRoot.add("Kathy",new Person());
      BSTRoot.add("Sean",new Person());
      BSTRoot.add("Brett",new Person());
      BSTRoot.add("Lance",new Person());
      BSTRoot.add("Pat",new Person());
      BSTRoot.add("Whitney",new Person());
      BSTRoot.add("Chad",new Person());
      BSTRoot.add("Maria",new Person());
      BSTRoot.add("Reba",new Person());
      BSTRoot.add("Zak",new Person());
      BSTRoot.add("Britany",new Person());
      BSTRoot.add("Doug",new Person());
      BSTRoot.add("Derek",new Person());
      BSTRoot.add("Dan",new Person());
      BSTRoot.add("Dirk",new Person());
   
      
      //visualize(BSTRoot);
      
      BSTRoot.remove("Pat");   // Removing element with one child
      BSTRoot.remove("Sean");  // Removing element with two child
      BSTRoot.remove("Kathy"); // Removing element with two children
      BSTRoot.remove("Megan"); // Removing root
      
      visualize(BSTRoot);
      
      System.out.println(BSTRoot.search("Kathy"));
      System.out.println(BSTRoot.search("Sean"));
      System.out.println(BSTRoot.search("Brett"));
      System.out.println(BSTRoot.search("Lance"));
      System.out.println(BSTRoot.search("Pat"));
      System.out.println(BSTRoot.search("Whitney"));
      System.out.println(BSTRoot.search("Chad"));
      System.out.println(BSTRoot.search("Maria"));
      System.out.println(BSTRoot.search("Reba"));
      System.out.println(BSTRoot.search("Zak"));
      System.out.println(BSTRoot.search("Britany"));
      System.out.println(BSTRoot.search("Doug"));
      System.out.println(BSTRoot.search("Derek"));
      System.out.println(BSTRoot.search("Dan"));
      System.out.println(BSTRoot.search("Dirk"));
      
   }
   
   public static <K extends Comparable<K>,V> void visualize(BSTNode<K,V> aNode) {
	   //TODO Add your own log in for this pls 
		Bridges bridges = new Bridges(0, "Dwr3k", "1263169290897");

	    /* Set an assignment title */
	    bridges.setTitle("Derrick Lab 12");
	    bridges.setDataStructure(aNode);

		try {
			bridges.visualize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RateLimitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   
   static class Person{
	   String name;
	   int age;
	   int height;
	   public String toString() {
		   return "";
	   }
   }
  
}

