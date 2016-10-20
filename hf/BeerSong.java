public class BeerSong{
     public static void main(String[] args){
	   int x = 99;
	   String text = "бутылок (бутылки)";
	   
	   while (x > 0){
		   
	      if (x == 1){
		    text = "бутылка";
		  } 
		  System.out.println(x + " "+ text + " пива на стене");
		  System.out.println(x + " "+ text + " пива!");
		  System.out.println("Возьми одну, пусти по кругу");
		  x = x - 1;
		  
		  if (x > 0){
		     System.out.println(x + " "+ text + " пива на стене!");
		  }
		  else{
		     System.out.println("Нет бутылок пива на стене!");
		  }
	   }
	 }
}