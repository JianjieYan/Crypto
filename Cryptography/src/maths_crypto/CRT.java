package maths_crypto;
public class CRT {
	// for x=a % m
	static long CRT(long [] a, long [] m){
		inverseMod iv=new inverseMod();
		int len=a.length;
		long [] N=new long[len];
		long [] M=new long[len];
		long sum=1;
		
		for(int i=0;i<len;i++) {
			sum=sum*m[i];
		}
		//System.out.println(sum);
		for(int i=0;i<len;i++) {
			M[i]=sum/m[i];
			System.out.println(M[i]);
			N[i]=iv.modInverse(M[i], m[i]);

		}
		long x=0;
		for(int i=0;i<len;i++) {
			x+=a[i]*M[i]*N[i];
		}
		x=x%sum;
		return x;
	}
	 
	//Chinese Remainder Theory(Garner's Formula)
	static long CRT2(long a, long b, long p,long q) {
		
		inverseMod iv=new inverseMod();
		
		long T;
		long u;
		long x;
		T=iv.modInverse(p, q);
		u=((b-a)*T)%q;
		x=a+u*T;
		return x;
	}
	public static void main (String[]args) {
		
		long a[]= {242654849,12488874};
		long m[]= {625486613,625486639};
		
		System.out.println(CRT(a,m));
	}

}
