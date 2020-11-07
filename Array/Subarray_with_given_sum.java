import java.util.*;

class Subarray_with_given_sum {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0){
	        int n = sc.nextInt();
	        int sum = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i = 0; i<n; i++){
	            arr[i] = sc.nextInt();
	        }
	        givensum(arr, n, sum);
	    }
	}
	
	public static void givensum(int[] arr, int n, int sum){
	    int cs = 0, start = 0, flag = 0;
	    int i;
	    for(i = 0; i<n; i++){
	        if( cs + arr[i] <= sum ){
	            cs += arr[i];
	        }else{
	            cs += arr[i];
	            while( cs > sum ){
	                cs -= arr[start];
	                start++;
	            }
	        }
	        if( cs == sum ){
	            int end = i;
	            System.out.println(start + " " + end);
	            flag = 1;
	            break;
	        }
	    }
	    if( flag == 0 ){
	        System.out.println(-1);
	        return;
	    }
	}
}