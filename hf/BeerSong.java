public class BeerSong{
     public static void main(String[] args){
	   int x = 99;
	   String text = "bottles";
	   
	   while (x > 0){
		   
	      if (x == 1){
		    text = "bottle";
		  } 
		  System.out.println(x + " "+ text + " beer on the wall");
		  System.out.println(x + " "+ text + " of beer!");
		  System.out.println("Take one down and pass arround");
		  x = x - 1;
		  }
		  if (x > 0){
		     System.out.println(x + " "+ text + " of beer on the wall!");
		  }
		  else{
		     System.out.println("No more bottle on the wall!");
		  }
	   }
	 
}