package LFSR;
import java.math.*;
	
import java.util.Arrays;
public class Methods {
	public int [] toInt(String[]s) {
		int res[]=new int[s.length];
		for(int i=0;i<s.length;i++) {
			res[i]=Integer.parseInt(s[i]);
		}
		return res;
	}
	public int Xor(int n, int m) {
		if(n==m) {
			return 0;
		}
		else {
			return 1;
		}
	}
	 public static  int[] multiplyMatrices(int[] firstMatrix, int[][] secondMatrix,  int len) {
	        int[] product = new int[len];
	        for(int i = 0; i < 1; i++) {
	            for (int j = 0; j < len; j++) {
	                for (int k = 0; k < len; k++) {
	                    product[j] += firstMatrix[k] * secondMatrix[k][j];
	                }
	            }
	        }

	        return product;
	    }
	 public static int [][] fillMatrix(int [] z){
		 int c=0;
		 int matrix[][]=new int[48][48];
		 for(int i=0;i<48;i++) {

			 c=i;
			 for(int j=0;j<48;j++) {
				 matrix[i][j]=z[c];
				 c++;
			 }
			 
		 }
		 
		 return matrix;
	 }
	public static void main(String []args) {
		int [] x= {1};
		int len=x.length;
		int [][]y= {{112,3,114},{112,15,6},{13,116,117}};
		
		int result[]=multiplyMatrices(x,y,len);
		System.out.println(Arrays.toString(result));
		
	}
	
	
	static final int N = 4; 
	  
	// Function to get cofactor of A[p][q] in temp[][]. n is current 
	// dimension of A[][] 
	static void getCofactor(int A[][], int temp[][], int p, int q, int n) 
	{ 
	    int i = 0, j = 0; 
	  
	    // Looping for each element of the matrix 
	    for (int row = 0; row < n; row++) 
	    { 
	        for (int col = 0; col < n; col++) 
	        { 
	            // Copying into temporary matrix only those element 
	            // which are not in given row and column 
	            if (row != p && col != q) 
	            { 
	                temp[i][j++] = A[row][col]; 
	  
	                // Row is filled, so increase row index and 
	                // reset col index 
	                if (j == n - 1) 
	                { 
	                    j = 0; 
	                    i++; 
	                } 
	            } 
	        } 
	    } 
	} 
	  
	/* Recursive function for finding determinant of matrix. 
	n is current dimension of A[][]. */
	static int determinant(int A[][], int n) 
	{ 
	    int D = 0; // Initialize result 
	  
	    // Base case : if matrix contains single element 
	    if (n == 1) 
	        return A[0][0]; 
	  
	    int [][]temp = new int[N][N]; // To store cofactors 
	  
	    int sign = 1; // To store sign multiplier 
	  
	    // Iterate for each element of first row 
	    for (int f = 0; f < n; f++) 
	    { 
	        // Getting Cofactor of A[0][f] 
	        getCofactor(A, temp, 0, f, n); 
	        D += sign * A[0][f] * determinant(temp, n - 1); 
	  
	        // terms are to be added with alternate sign 
	        sign = -sign; 
	    } 
	  
	    return D; 
	} 
	  
	// Function to get adjoint of A[N][N] in adj[N][N]. 
	static void adjoint(int A[][],int [][]adj) 
	{ 
	    if (N == 1) 
	    { 
	        adj[0][0] = 1; 
	        return; 
	    } 
	  
	    // temp is used to store cofactors of A[][] 
	    int sign = 1; 
	    int [][]temp = new int[N][N]; 
	  
	    for (int i = 0; i < N; i++) 
	    { 
	        for (int j = 0; j < N; j++) 
	        { 
	            // Get cofactor of A[i][j] 
	            getCofactor(A, temp, i, j, N); 
	  
	            // sign of adj[j][i] positive if sum of row 
	            // and column indexes is even. 
	            sign = ((i + j) % 2 == 0)? 1: -1; 
	  
	            // Interchanging rows and columns to get the 
	            // transpose of the cofactor matrix 
	            adj[j][i] = (sign)*(determinant(temp, N-1)); 
	        } 
	    } 
	} 
	  
	// Function to calculate and store inverse, returns false if 
	// matrix is singular 
	static int [][] inverse(int A[][], float [][]inverse) 
	{ 
	    // Find determinant of A[][] 
	    int det = determinant(A, N); 
	    if (det == 0) 
	    { 
	        System.out.print("Singular matrix, can't find its inverse"); 
	        return null; 
	    } 
	  
	    // Find adjoint 
	    int [][]adj = new int[N][N]; 
	    adjoint(A, adj); 
	  int [][] result=new int[48][48];
	    // Find Inverse using formula "inverse(A) = adj(A)/det(A)" 
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            result[i][j] = (int)((adj[i][j]%2)/((float)det%2)); 
	  
	}}
	    
	    
	    return result; 
	    
	} 
}

