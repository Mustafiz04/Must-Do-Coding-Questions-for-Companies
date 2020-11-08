import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    String str = sc.next();
		    permutation(str, 0, str.length()-1 );
		    System.out.println();
		}
		sc.close();
	}
	
	public static void permutation(String str, int l, int r){
	    if( l == r ){
	        System.out.print(str + " ");
	        
	    }
	    for(int i = l; i<=r; i++){
	        str = swap(str, l, i);
	        permutation(str, l+1, r);
	        str = swap(str, l, i);
	    }
	}
	
	public static String swap(String str, int i, int j){
	    char temp;
	    char[] s = str.toCharArray();
	    temp = s[i];
	    s[i] = s[j];
	    s[j] = temp;
	    return String.valueOf(s);
	}
}