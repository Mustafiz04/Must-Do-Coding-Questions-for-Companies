import java.util.*;
import java.io.*;

class Longest_Increains_Subsquence {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i<n; i++){
		        arr[i] = sc.nextInt();
		    }
		    int l = LIS(arr, n);
		    System.out.println(l);
		}
	}
	
	public static int LIS(int[] arr, int n){
	    int[] mat = new int[n];
	    
	    for (int i = 0; i < n; i++ ) 
               mat[i] = 1; 
	    
	    for(int i = 1; i<n; i++){
	        for(int j = 0; j<i; j++){
	            if( arr[i] > arr[j] && mat[i] <= mat[j] ){
	                mat[i] = mat[j] + 1;
	            }
	        }
	    }
	    int max = 1;
	    for ( int i = 0; i < n; i++ ) 
            if ( max < mat[i] ) 
              max = mat[i]; 

        return max; 
	}
}