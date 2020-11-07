import java.util.*;

class MissingNumber {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0){
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i = 0; i<n-1; i++){
	            arr[i] = sc.nextInt();
	        }
	        System.out.println(missing(arr, n));
	    }
	}

	public static int missing(int[] arr, int n){
	    int total = (n * (n+1))/2;
	    for(int i = 0; i<n-1; i++){
	        total -= arr[i];
	    }
	    return total;
	    
	}
}