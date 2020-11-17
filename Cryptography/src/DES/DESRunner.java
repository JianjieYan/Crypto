package DES;

import java.util.Arrays;

public class DESRunner {
	static String []keySpace=new String[16];
	public static void main(String[]args) {
		String plainText="1010010110100101101001011010010110100101101001011010010110100101";
		String key="1111111111111111111111111111111111111111111111111111111111111111";
		Methods.keyGeneration(key);
		keySpace=Methods.keyStore;
		System.out.println();
		
		String cipherText=Encryption(plainText,key);
		System.out.println("CipherText is: "+cipherText);
		
		System.out.println("PlainText is: "+Decryption(cipherText,key));


		
	}
	public static String Encryption(String plainText,String key) {
		
		String cipher=Permutation.getResult(plainText, "IP");
		
		for(int i=0;i<16;i++) {
			
			cipher = Methods.round(cipher, keySpace[i]);
			
		}
		String swapedCipher=cipher.substring(32,64)+cipher.substring(0,32);
		
		cipher=Permutation.getResult(swapedCipher, "IPInverse");
		return cipher;
	}
	
	public static String Decryption(String cipherText, String key) {
		String plainText= Permutation.getResult(cipherText, "IP");

		int count=15;
		for(int i=0;i<16;i++) {
			plainText=Methods.round(plainText, keySpace[count]);
			count--;
		}
		
		String swapedPlain=plainText.substring(32,64)+plainText.substring(0,32);
		plainText=Permutation.getResult(swapedPlain, "IPInverse");

		return plainText;
		
		
	}

}
