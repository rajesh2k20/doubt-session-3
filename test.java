package cfc_question;

import java.math.BigInteger;
import java.util.*;

public class test {

	public static void main(String[] args) {
		 int n,m;
	     Scanner s=new Scanner(System.in);
          n=s.nextInt();
          m=s.nextInt();
	     int arr[]=new int[10];
	     int index=0;
	     int sum=0;
	     for(int i=m;i<=m*10;i+=m){
	        
	        arr[index]= i%10;
	        sum+=arr[index];
	        index++;
	     }
	     
	     int nofmul= n/m;// nofmu=number of multiple of m in 1 to n.

	      sum=  sum*(nofmul/10);
	     
	     int rem= nofmul%10;
	     for(int i=0;i<rem;i++){
	        sum+=arr[i];
	     }
	     System.out.print(sum);
		 
		

	}

}
