/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i<n; i++){
		        arr[i] = sc.nextInt();
		    }
		    sort(arr, n);
		}
	}
	
	public static void sort(int[] arr, int n){
	    int start = 0;
	    int mid = 0;
	    int last = n-1;
	    
	    while( mid <= last ){
	        switch( arr[mid] ){
	            case 0:
	                swap(arr, start++, mid++ );
	                break;
	            case 1:
	                mid++;
	                break;
	            case 2:
	                swap( arr, mid, last-- );
	                break;
	        }
	    }
	    for(int i = 0; i<n; i++){
	        System.out.print(arr[i] + " " );
	    }
	    System.out.println();
	}
	
	public static void swap(int[] arr, int i, int j){
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}