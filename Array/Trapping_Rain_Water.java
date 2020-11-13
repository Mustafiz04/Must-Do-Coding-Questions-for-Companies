/*package whatever //do not write package name here */

import java.util.*;

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
		    System.out.println(tappingRainWater(arr, n));
		}
	}
	
	public static int tappingRainWater(int[] arr, int n){
	    int ans = 0;
	    
	    for(int i = 1; i<n-1; i++){
	        int left = arr[i];
	        for(int j = 0; j<i; j++){
	            left = Math.max(left, arr[j]);
	        }
	        int right = arr[i];
	        for(int j = i+1; j<n; i++){
	            right = Math.max(right, arr[j]);
	        }
	        
	        ans += Math.min(left, right) - arr[i];
	    }
	    return ans;
	}
}