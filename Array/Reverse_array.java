// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}

class Reverse{
    public static String reverseWord(String str){
        // String ans = "";
        // for(int i = str.length()-1; i>=0; i--){
        //     ans += str.charAt(i);
        // }
        // return ans;
        char[] arr = str.toCharArray();
        int start = 0, end = str.length()-1;
        while(start < end ){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }
}