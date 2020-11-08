import java.util.*;

class GFG {
    public static void main (String[] args)throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];
            
            Anagram obj = new Anagram();
            
            if(obj.isAnagram(s1,s2))
            {
                System.out.println("YES");
            }
            else
            {
                    System.out.println("NO");
            }
            
            
            
        }
    }
}

class Anagram{ 
    public static boolean isAnagram(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        if( n1 != n2  ){
            return false;
        }
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        for(int i = 0; i<n1; i++){
            if( c1[i] != c2[i] ){
                return false;
            }
        }
        return true;
    }
}