package Crypto_Tool;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class playFairCipher {

	public static void main(String[]args) {
		String s="GVDPU ODTDL MFDME MMUSX MDWRD GAEEZ AUSZB LETAO"
				+ " LDARA WAUEZ AUSZH QCKAU RETUB NDCPK OFRNQ PNMCS\r\n"
				+ " OBASN IDMBP OAUZK PUBFT MTFXX FTDNM NVUNF ILDFE\r\n"
				+ " TRKAH QARES RVRQD MFXTA SRNHI BQRPR GQUZA ELDVB\r\n"
				+ " AKFAM ITUQP CUAEA CQNKW LDHSD QRTFS RAAYT ACWLD\r\n"
				+ " BSACM CARBQ TRAET DABAK AQKLR KHQRN CRAUH DADAS\r\n"
				+ " BEMTT RCTBK SZGVH QCULD NRANM DNMKC UDANU AYEHD\r\n"
				+ " SEMRI SUHXF PDLDH SCTLK XNPKM FNHIB QRPRG TQKAT\r\n"
				+ " LDHQR KBIRU TSBEM TTRCT BKSZG VHQRK ESHQS RODAD\r\n"
				+ " LDFSM USNQP LBKRR IWSWR SVLSD LKWRU HUDXA ETSRQ\r\n"
				+ " DMDMH QATRE AWART SMUHQ ARESS GFARV OACTQ TUSTM\r\n"
				+ " HAQTT ASUQP MZRUL DFAZX SXGVH QRCBV RQTGR NDPDL\r\n"
				+ " TRESR QDMLD VBAKF AUVCT UAWRS VTDDO NHHQT UINBK\r\n"
				+ " RSURK XSTCN XNQAC TVBDM FSRAE YAECK QNTAN RMUKS\r\n"
				+ " MQKAT GOEDN RTVRA TDOCU AETCD NTARV OFTHA KTMUA\r\n"
				+ " WFCTK OAETR EAARF AMISE PKSNA URTRE AWARR ENZMQ\r\n"
				+ " EYAES KEFWC RVOAT HCTBK SZFTX NXAAW RONZD TRERL\r\n"
				+ " MAFAO RESSG FTRIA WAUTR MQKSN RMUFB CKLQD QOATA\r\n"
				+ " TRRFP KTGRU HTTAS EFBRW AEZMH QAEHN SDNHR EFAGY\r\n"
				+ " DTAQA SDVMF HQCKQ RMSKB FTAKH UXNPK MAHQT DYELD\r\n"
				+ " HQRCF XQAMT RSERT FDEPK MFNSE HFTEH TDWCL SEIUN\r\n"
				+ " FILDL DRPUR HQCKS TAQAT REFAC SNMTA AZAQL DPGHT\r\n"
				+ " BVATH TUQQT INDMT ULNBL KCETQ THQPD TAXLL DBQTE\r\n"
				+ " NZDOF TDVMF SLLSE AOAPX HQDNH BHQRC ARESW SUDUA\r\n"
				+ " DVHEP DGVEA WRFXL DHBPR RNRBA TTSMD HQAEZ UNMUR\r\n"
				+ " OBPDT AXLLD EFFLT UMUSN ATREA WARFA UBXFP DRUHU\r\n"
				+ " SYAUT SRQDM STFAV BRXKB RQOSF TSODT DLMFL DBQTM\r\n"
				+ " LNBLK CCSUA ESPAV BUADV PNEFE ARNWG DONSM UAELD\r\n"
				+ " FBKRH NHACT IBQRP RBGDT KCRPD LEAXF MUHUM AVRAE\r\n"
				+ " RUBQT MQSQD MAHQR KESFT MRREE KLETA WREAF IUZHQ\r\n"
				+ " RKDLR QFXFE XNPAE MFYCS TRRUN SVGAC LBSZN HBLKC\r\n"
				+ " ETURR NDPFB SAKFN QPKMA MRENN RBKDN GYXFM AFTNR\r\n"
				+ " LYLSE AOAPX LDBKU AESRA ORCTA URQEA IBQRP RBQOA\r\n"
				+ " AKPKC SUFAU ARZUE IUNTR ZCAUQ RGPBV KYSTF KMTLD\r\n"
				+ " BSDNM UBQNY";
		s=s.replace(" ", "");
		s=s.replace("\r\n", "");

		char[][] temp=getRandomTable();

			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
		
		/*	for(int j=0;j<1000;j++) {
				
				for(int i=0;i<1000;i++) {
					temp=getRandomTable();

					decode(temp,s);
				
				}

				//System.out.println();
				
			}*/
			int count=0;        //decode with the key
			String key="DUNMOREASTBCFGHIKLPQVWXYZ";
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					temp[i][j]=key.charAt(count);
				count++;
				}
			}
			String plainText=decode(temp,s);
			
			//System.out.println(plainText.replaceAll("X",""));
			String PlainTextWithoutX=removeX(plainText);

			System.out.println(PlainTextWithoutX.substring(0,PlainTextWithoutX.length()-1));


	}
	
	static String removeX(String plainText) {
		
		for(int i=1;i<plainText.length()-1;i++) {
			if(plainText.charAt(i)=='X'&(plainText.charAt(i-1)==plainText.charAt(i+1))) {
				
				plainText=plainText.substring(0,i-1)+plainText.charAt(i-1)+plainText.substring(i+1);
				
			}
		}
		
		return plainText;
	}
	static String decode(char[][]table,String cipher) {
		String [] temp=new String[cipher.length()/2];
		int startIndex=0;
		for(int i=0;i<temp.length;i++) {
			temp[i]=cipher.substring(startIndex,startIndex+2);
			startIndex=startIndex+2;
		}
		int [] indexs=new int[4];
		String plainText="";
		for(int i=0;i<temp.length;i++) {
			indexs=getIndex(table,temp[i]);
			int x=indexs[0];
			int y=indexs[1];
			int m=indexs[2];
			int n=indexs[3];

			if((indexs[0]==indexs[2])&(y!=n)) {//same row
				if(y==0) {
					plainText+=table[x][4]+""+table[m][n-1]+"";
					
				}
				else if(n==0) {
					plainText+=table[x][y-1]+""+table[m][4];
					
				}
				else {
				plainText+=table[x][y-1]+""+table[m][n-1]+"";
				}
			}
			else if((x!=m)&(indexs[1]==indexs[3])) {//same column
				if(x==0) {
					plainText+=table[4][y]+""+table[m-1][n];
				}
				else if(m==0) {
					plainText+=table[x-1][y]+""+table[4][n];
				}
				else {
				plainText+=table[x-1][y]+""+table[m-1][n];				
				}
			}
			else {
				plainText+=table[x][n]+""+table[m][y];
			}
			
			

			
		}
		/*if(plainText.contains("BYMIDMORNINGONSUNDAYNOVEMBERTWENTYFIRSTNINETEXENTWENTY")) {
			System.out.println(plainText);
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}			
			

		}*/
		return plainText;



		
	}
	
	
	static int [] getIndex(char [][]table, String s) {
		int x = 0,y=0,m=0,n=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(table[i][j]==(s.charAt(0))) {
					x=i;
					y=j;
				}
				if(table[i][j]==(s.charAt(1))) {
					m=i;
					n=j;
				}
			}
		}
		int index[]=new int[4];
		index[0]=x;
		index[1]=y;
		index[2]=m;
		index[3]=n;
		return index;
		
	}
	
	static char[][] getRandomTable() {
		char [][] table=new char[5][5];
		table[4][0]='V';
		table[4][1]='W';
		table[4][2]='X';
		table[4][3]='Y';
		table[4][4]='Z';
		
		table[1][1]='E';
		table[1][2]='A';
		table[1][0]='R';

		table[0][0]='D';
		table[0][1]='U';
		table[0][2]='N';
		table[0][3]='M';
		table[0][4]='O';
		table[2][0]='B';
		table[2][3]='G';
		table[3][0]='I';
		table[3][3]='P';

		


	    int numChar[]=new int[9];
	    numChar[0]=83;
	    numChar[1]=67;
	    numChar[2]=85;
	    numChar[3]=70;
	    numChar[4]=72;
	    numChar[5]=84;
	    numChar[6]=75;
	    numChar[7]=76;
	    numChar[8]=81;

	


	    
		int count2=0;
		
		
			Integer[] arr = new Integer[9];
				for (int k = 0; k < arr.length; k++) {
					arr[k] = k;
				}
			Collections.shuffle(Arrays.asList(arr));//get random non repeat numbers;
			
	    //fill the table with the 
	    for(int i=1;i<4;i++) {
			for(int j=0;j<5;j++) {
				 if(i==2&j==0) {}
				 else if(i==2&j==3) {}
				 else if(i==3&j==0) {}
				 else if(i==3&j==3) {} 
				 else if(i==1&j==2) {} 
				 else if(i==1&j==1) {} 
				 else if(i==1&j==0) {} 

				 else {
				    table[i][j]=(char) numChar[arr[count2]];
				    count2++;
				 }
			}

		}

		count2=0;
		return table;
	}
}
