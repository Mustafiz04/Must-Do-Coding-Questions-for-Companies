import java.util.*;

class NoToRoman{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int N = sc.nextInt();
            
            GfG g = new GfG();
            System.out.println (g.convertToRoman(N));
            t--;
        }
    }
}

class GfG{
    String convertToRoman(int n){
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        
        String roman = "";
        
        for( Map.Entry<String, Integer> ent : roman_numerals.entrySet() ){
            int match = n / ent.getValue();
            roman += repeat(ent.getKey(), match);
            n %= ent.getValue();
        }
        return roman;
    }
    public static String repeat(String m, int n){
        if( m == null ){
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            sb.append(m);
        }
        return sb.toString();
    }
}