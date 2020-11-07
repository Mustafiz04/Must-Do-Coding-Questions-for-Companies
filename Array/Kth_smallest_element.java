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
		    int k = sc.nextInt();
		    
		    System.out.println(kSmallestElement(arr, n, k));
		}
	}
	
	public static int kSmallestElement(int[] arr, int n, int k){
	    Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
	    
	    for(int i = 0; i<n; i++){
	        q.add(arr[i]);
	        if( q.size() > k ){
	            q.poll();
	        }
	    }
	    return q.poll();
	}
}