package maths_crypto;

public class toBinary {
	public static String toBinary(int decimal){    
	     int binary[] = new int[40];    
	     int index = 0;    
	     while(decimal > 0){    
	       binary[index++] = decimal%2;    
	       decimal = decimal/2;    
	     } 
	     String result="";
	     for(int i = index-1;i >= 0;i--){    
	       result+=binary[i];    
	     }    
	     
	     int len=result.length();
	     while(len<4) {
	    	 result="0"+result;
	    	 len++;
	     }
	     return result;
	}
}
