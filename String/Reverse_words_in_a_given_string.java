import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    String[] str = sc.next().split("\\.");
		    reverse(str);
		}
	}
	
	public static void reverse(String[] str){
	    int n = str.length;
	    
	    for(int i = n-1; i>0; i--){
	        System.out.print(str[i] + ".");
	    }
	    System.out.println(str[0]);
	}
}