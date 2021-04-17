import java.util.Random;

public class Oprations {

	public static void main(String[] args) {
		
		Random random = new Random();
		int x = random.nextInt(999);  
		String str = "CANON 418 CYAN 8278";
		String output1;
		
//		String output = (str.length()>10) ? str.substring (0,10).concat(""):str;
		
		if ((str.length()>15))
		{
			 output1 = str.substring (0,14) +" "+ x;
//			System.out.println(output1+" "+ x);
		}
		else 
		{
			 output1 = str +" "+ x;
//			System.out.println(output1+" "+ x);
		}
		
//		str = str.substring(Math.min(str.length(), 5));
		
//		int strln = str.length();
//		 String result1 = truncate(str, 2);
	        System.out.println(output1);
//		if (strln > 14)
//		{
//			
//		}
//		
		
		
		
		
//		else
//		{
//			str = str.substring(0, Math.min(str.length(), 14)) + x;
//			
//		}
//		System.out.println(output);
		
//		System.out.println(x);
		
	}

	
}