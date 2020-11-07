import java.util.*;

class Leaders_in_an_array {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0){
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i = 0; i<n; i++){
	            arr[i] = sc.nextInt();
	        }
	        leader(arr, n);
	    }
	}
	public static void leader(int[] arr, int n){
		Stack<Integer> s = new Stack<Integer>();
		int maxR = arr[n-1];
		s.push(maxR);
		for(int i = n-2; i>= 0; i--){
			if( maxR <= arr[i] ){
				maxR = arr[i];
				s.push(maxR);      
			}
		}
		while( !s.isEmpty() ){
			System.out.print(s.pop() + " ");
		}
		System.out.println();
	}
}