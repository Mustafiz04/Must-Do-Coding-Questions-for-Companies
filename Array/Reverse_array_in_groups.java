import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i<n; i++){
		        arr[i] = sc.nextInt();
		    }
		    reverseArrayInGroup(arr, n, k);
		}
	}
	
	public static void reverseArrayInGroup(int[] arr, int n, int k){
	    for(int i = 0; i<n; i+=k){
	        int left = i;
	        int right = Math.min(i+k-1, n-1);
	        int temp;
	        while(left < right){
	            temp = arr[left];
	            arr[left] = arr[right];
	            arr[right] = temp;
	            left++;
	            right--;
	        }
	    }
	    for(int i = 0; i<n; i++){
	        System.out.print(arr[i] + " ");
	    }
	    System.out.println();
	}
}