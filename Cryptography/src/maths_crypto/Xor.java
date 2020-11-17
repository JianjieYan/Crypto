package maths_crypto;

public class Xor {
	public static String getXor(String n, String m) {
	
		String result="";
		for(int i=0;i<n.length();i++) {
			if(n.charAt(i)==m.charAt(i)) {
				result+=0;
			}
			else {
				result=result+1;
			}
		}
		return result;
		
	}
}

