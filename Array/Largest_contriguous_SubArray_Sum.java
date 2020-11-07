import java.util.*;

class Kadane {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0){
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i = 0; i<n; i++){
	            arr[i] = sc.nextInt();
	        }
	        System.out.println(kadene(arr, n));
	    }
	}
    
    // Subarray with maximum sum
	public static int kadene(int[] arr, int n){
	    int maxSum = arr[0];
	    int maxSoFar = arr[0];
	    
	    for(int i = 1; i<n; i++){
	        maxSum = Math.max(arr[i] , maxSum+arr[i]);
	        maxSoFar = Math.max(maxSum, maxSoFar);
	    }
	    return maxSoFar;
	}

    // starting and ending index of maximum subarray sum
	static void maxSubArraySum(int a[], int size) { 
        int max_so_far = Integer.MIN_VALUE, 
        max_ending_here = 0, start = 0, 
        end = 0, s = 0; 

        for (int i = 0; i < size; i++)  { 
            max_ending_here += a[i]; 

            if (max_so_far < max_ending_here)  { 
                max_so_far = max_ending_here; 
                start = s; 
                end = i; 
            } 

            if (max_ending_here < 0)  { 
                max_ending_here = 0; 
                s = i + 1; 
            } 
        } 
        System.out.println("Maximum contiguous sum is " + max_so_far); 
        System.out.println("Starting index " + start); 
        System.out.println("Ending index " + end); 
    } 
}