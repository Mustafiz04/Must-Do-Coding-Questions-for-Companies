import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    String str = sc.next();
		    char[] arr = str.toCharArray();
		    LPS(arr, str.length() );
		}
	}
	
	public static void LPS(char[] arr, int n){
	    boolean[][] mat = new boolean[n][n];

        int maxLength = 1;
        for(int i = 0; i<n; i++){
            mat[i][i] = true;
        }
        int start = 0;

        for(int i = 0; i< n-1; i++){
            if( arr[i] == arr[i+1]){
                mat[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for(int i = 3; i<=n; i++){
            for(int s = 0; s<n-i+1; s++){
                int e = i + s - 1;
                if( arr[s] == arr[e] && mat[s+1][e-1] ){
                    mat[s][e] = true;

                    if( i > maxLength){
                        start = s;
                        maxLength = i;
                    }

                }
            }
        }
        printSubStr(arr, start, start + maxLength - 1);
        // return maxLength;
	    
	}
	private static void printSubStr(char[] arr, int start, int end) {
        for(int i = start; i<=end; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
	
}