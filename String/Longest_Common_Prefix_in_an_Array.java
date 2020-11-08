package string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = { "program", "programmer", "programming" };
        String pre = longestCommonPrefix(arr);
        System.out.println(pre);
    }


    public static String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0 ){
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length-1);
    }
    
    public static String longestCommonPrefix( String[] str, int l, int r ){
        if( l == r ){
            return str[l];
        }else{
            int mid = (l + r)/2;
            String lcpleft = longestCommonPrefix( str, l, mid );
            String lcpright = longestCommonPrefix( str, mid+1, r );
            return commonPrefix( lcpleft, lcpright );
        }
    }
    
    public static String commonPrefix( String left, String right ){
        int min = Math.min( left.length(), right.length() );
        for(int i = 0; i<min; i++){
            if( left.charAt(i) != right.charAt(i) ){
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
