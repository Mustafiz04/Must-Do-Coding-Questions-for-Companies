import java.util.*;

class Minimum_number_of_platform {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    int[] dep = new int[n];
		    
		    for(int i = 0; i<n; i++){
		        arr[i] = sc.nextInt();
		    }
		    for(int i = 0; i<n; i++){
		        dep[i] = sc.nextInt();
		    }
		    
		    System.out.println(platform(arr, dep, n));
		}
	}
	
	public static int platform(int[] arr, int[] dep, int n){
	    Arrays.sort(arr);
	    Arrays.sort(dep);
	    
        int plat = 1;
        int result = 1;
        int i = 1;
        int j = 0;
        
        while( i < n && j < n ){
            if( arr[i] <= dep[j] ){
                plat++;
                i++;
            }else if( arr[i] > dep[j] ){
                plat--;
                j++;
            }
            
            if( result < plat ){
                result = plat;
            }
        }
        
        return result;
	}
}