package DES;
import java.util.Arrays;

import maths_crypto.*;
public class Methods {
	public static String [] keyStore=new String[16];
	
	//Generate Key Array for 16 subkeys;
	public static void keyGeneration(String key) {
		
		String first=Permutation.getResult(key,"PC1"); //takes 67 bits, and reduce to 56 bits;

		
		String c=first.substring(0,28);
		String d=first.substring(28,56);

		for(int i=0;i<16;i++) {
			int shiftNum=1;
			for(int j=0;j<shiftNum;j++) {
				
				c=leftShift(c);

				d=leftShift(d);
			}
			String cd=c+d;
			String subkey=Permutation.getResult(cd,"PC2");			
			keyStore[i]=subkey;

		}
		
	}
	
	public static String leftShift(String s) {
		String result="";
		
		result=s.substring(1,28)+s.charAt(0);
		
		return result;
	}
	
	//One round of DES. 
	public static String round(String text,String subkey) {
		
		String left=text.substring(0,32);
		String right=text.substring(32,64);
		
		String result=right;
		
		String fOutput=fFunction(right,subkey);
		
		String subResult="";
		subResult=Xor.getXor(left, fOutput);
		
		result+=subResult;
		
		
		return result;
	}
	
	//Entire F function;
	public static String fFunction(String R,String K) {
		String first=Permutation.getResult(R,"E");
		//System.out.println(first.length());
		
		
		String second =Xor.getXor(first, K);
		//System.out.println(second.length());
	
		String third =SBox.getResult(second);
		
		//System.out.println(third.length());
		
		String fourth=Permutation.getResult(third,"P");
		
		//System.out.println(fourth.length());
		
		
		return fourth;
	}
	
	//Get 32 bits output from S Box; input 48 bits String;
	
	//permutation and return output string;
	
}
