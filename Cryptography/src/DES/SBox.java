package DES;

import maths_crypto.toBinary;
import maths_crypto.toDecimal;

public class SBox {
	static int [][] s1= {{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},{0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},{4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},{15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}};

	static int [][] s2= {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},{3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},{0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},{13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};

	static int [][] s3= {{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},{13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},{13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},{1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}};

	static int [][] s4= {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},{13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},{10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},{3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}};

	static int [][] s5= {{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},{14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},{4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},{11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}};

	static int [][] s6= {{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},{10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},{9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},{4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}};

	static int [][] s7= {{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},{13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},{1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},{6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}};

	static int [][] s8= {{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},{1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},{7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},{2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}};
	
	public static String getResult(String s){
		String s1=s.substring(0,6);
		String s2=s.substring(6,12);
		String s3=s.substring(12,18);
		String s4=s.substring(18,24);
		String s5=s.substring(24,30);
		String s6=s.substring(30,36);
		String s7=s.substring(36,42);
		String s8=s.substring(42,48);
		
		
		String result="";
		
		result+=subSTable(s1,SBox.s1)+subSTable(s2,SBox.s2)+subSTable(s3,SBox.s3)+subSTable(s4,SBox.s4)+subSTable(s5,SBox.s5)+subSTable(s6,SBox.s6)+subSTable(s7,SBox.s7)+subSTable(s8,SBox.s8);
		
		
		return result;
	}
	//outputs of sub-s-table
	public static String subSTable(String s, int [][]sbox) {
		int row =Integer.parseInt(s.charAt(0)+""+s.charAt(5));
		row=toDecimal.toDecimal(row);
	//	System.out.println(row);
		
		int colum = Integer.parseInt(s.substring(1,5));
		colum=toDecimal.toDecimal(colum);

		int temp=sbox[row][colum];
		String result=toBinary.toBinary(temp);
		return result+"";
	}
	
}
