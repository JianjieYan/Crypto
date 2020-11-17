package LFSR;
import java.util.Arrays;

import org.apache.commons.math3.linear.AnyMatrix;
import org.apache.commons.math3.linear.MatrixUtils;

import java.math.*;
public class LFSR_GetKey {
	public static void main(String[]args) {
		Methods m=new Methods();
		
		String c="1001110101011110000010100100100001011000110000001001111101010001010010100110110100110101110001001111010001011001011100110000011011000101001100111011";
		String p="1111100001101011000011110001100001100001111000011100001111100001111111001111001011111111110000000110010101011011111100000000001111111110100110101010";
		String []c1=c.split("");
		String[]p1=p.split("");
		int len=c.length();
		int cipher[]=m.toInt(c1);
		int plain[]=m.toInt(p1);
		
	//	System.out.println(Arrays.toString(cipher));
		int z[]=new int [len];
		int k[]=new int [len];
		int zm[]=new int [48];
		int km[]=new int [48];
		
		
		for(int i=0;i<len;i++) {
			k[i]=z[i]=m.Xor(cipher[i], plain[i]);
		}


		int [][]s=m.fillMatrix(z);
		System.out.println(Arrays.toString(z));
		
		for(int i=0;i<s.length;i++) {
			for(int j=0;j<s.length;j++) {
				System.out.print(s[i][j]+" ");
			}
			System.out.println();
		}
		float f[][]=new float[48][48];
		int [][]in=new int [48][48];
		in=m.inverse(s, f);
		
		for(int i=0;i<48;i++) {
			for(int j=0;j<48;j++) {
				System.out.print(in[i][j]+" ");
			}
			System.out.println();
			
		}
		
		System.out.println(Arrays.toString(m.multiplyMatrices(z, in, 48)));
		
		//Stopped at inverse matrix
		
		/*String s2="";
		for(int i=0;i<48;i++) {
			s2+=z[i];
			km[i]=zm[i]=z[i];
		}
		System.out.println(s2);
*/
		
		
	}

}
