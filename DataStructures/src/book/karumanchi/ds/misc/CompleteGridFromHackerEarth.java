package book.karumanchi.ds.misc;

import java.io.Console;
import java.util.Scanner;


/*
 * This method is written for a problem i faced in online test which states to count sub square matrix of a square 
 * matrix in which either values are either 1 or O.
 * e.g
 * 1 // no of test cases
 * 4 // Size of square matrix
 * 
 * 1 1 1 1
 * 0 0 1 1
 * 0 0 1 1
 * 1 1 1 1
 * 
 * output will be 16(size of 1*1) + 4 (size of 2*2)=20
 * no 3*3 or 4*4 matrix are complete
 */
public class CompleteGridFromHackerEarth {
	    public static void main(String args[] ) throws Exception {
	        /*
	         * Read input from stdin and provide input before running
	         * Use either of these methods for input

	        */
	        Scanner s = new Scanner(System.in);
	            int N = s.nextInt();
	        //Scanner
	        while(N >0){
	            int k = s.nextInt();
	            int[][] arr= new int [k][k];
	            for(int j=0;j<k;j++){
	                for (int i = 0; i < k; i++) {
	                   arr[j][i]=s.nextInt(); 
	                }
	            }
	            try{
	            System.out.println(k*k+getCompleteSquare(arr,k));
	            }
	            catch(Exception e){
	            	
	            }
	        }

	    }
	    
		    private static int getCompleteSquare(int [][] arr,int n){
		    	int k=2;
		    	int count=0;
		    	while(n>k){
		    		for (int i=0; i<n-k+1; i++)
		    		   {
		    		      for (int j=0; j<n-k+1; j++)
		    		      {
		    		          int sum = 0;
		    		          for (int p=i; p<k+i; p++){
		    		             for (int q=j; q<k+j; q++){
		    		                 sum += arr[p][q];
		    		             }
		    		          }
		    		          if(sum ==0 || sum== k*k){
		    		        	  count++;
		    		          }
		    		      }
		    		 
		    		   }
		        k++;
		    	}
		    	return count;
		    }
	    
}
