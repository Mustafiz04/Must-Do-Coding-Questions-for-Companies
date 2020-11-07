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
		    arrayAlter(arr, n);
		}
	}
	
	public static void arrayAlter(int[] arr, int n){
	    int[] alter = new int[n];
	    int l = 0; 
	    int r = n-1;
	    int i = 0;
	    if( n % 2 == 0 ){
	        while( l < r ){
    	        alter[i++] = arr[r];
    	        alter[i++] = arr[l];
    	        r--;
    	        l++;
    	    }    
	    }else{
	        while( l < r ){
    	        alter[i++] = arr[r];
    	        alter[i++] = arr[l];
    	        r--;
    	        l++;
    	    }
    	    alter[i] = arr[l];
	    }
	    for(int j = 0; j<n; j++){
	        System.out.print(alter[j] + " ");
	    }
	    System.out.println();
	}
} 