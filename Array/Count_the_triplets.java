import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}

class Solution {
    int countTriplet(int arr[], int n) {
        int maxEle = 0;
        for(int i = 0; i<n; i++){
            maxEle = Math.max(maxEle, arr[i]);
        }
        int[] freq = new int[maxEle + 1];
        for(int i = 0; i<n; i++){
            freq[arr[i]]++;
        }
        int ans = 0;
        
        ans += freq[0] * (freq[0] - 1) * (freq[0] - 2) / 6;
        
        for(int i = 1; i<=maxEle; i++){
            ans += freq[0] * freq[i] * (freq[i] -1 ) / 2;
        }
        for(int i = 1; i*2<=maxEle; i++){
            ans += freq[i] * (freq[i] - 1) / 2  * freq[i*2];
        }
        
        for(int i = 1; i<=maxEle; i++){
            for(int j = i+1; i+j<=maxEle; j++){
                ans += freq[i] * freq[j] * freq[i+j];
            }
        }
        return ans;
    }
}