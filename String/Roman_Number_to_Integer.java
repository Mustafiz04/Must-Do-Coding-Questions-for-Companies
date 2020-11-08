import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    String str = sc.next();
		    System.out.println(romanToInt(str));
		}
	}
	
	public static int value( char r ){
        if (r == 'I') 
          return 1; 
        if (r == 'V') 
          return 5; 
        if (r == 'X') 
          return 10; 
        if (r == 'L') 
          return 50; 
        if (r == 'C') 
          return 100; 
        if (r == 'D') 
          return 500; 
        if (r == 'M') 
          return 1000; 
        return -1; 
    }
    
    public static int romanToInt(String s) {
        int total = 0;
        int len = s.length();
        for(int i = 0; i<len; i++){
            int v1 = value( s.charAt(i));
            if( i + 1 < len ){
                int v2 = value( s.charAt(i+1) );
                if( v1 >= v2 ){
                    total += v1;
                }else{
                    total -= v1;
                }
            }else{
                total += v1;
            }
        }
        return total;
    }
}