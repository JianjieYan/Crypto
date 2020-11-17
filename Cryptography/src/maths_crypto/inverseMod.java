package maths_crypto;


public class inverseMod {
	// m is the module
	 long modInverse(long a, long m) 
    { 
		 long m0 = m; 
        long y = 0, x = 1; 
  
        if (m == 1) 
            return 0; 
  
        while (a > 1) 
        { 
            // q is quotient 
        	long q = a / m; 
  
        	long t = m; 
  
            // m is remainder now, process 
            // same as Euclid's algo 
            m = a % m; 
            a = t; 
            t = y; 
  
            // Update x and y 
            y = x - q * y; 
            x = t; 
        } 
  
        // Make x positive 
        if (x < 0) 
            x += m0; 
  
        return x; 
    } 
  
    

}
