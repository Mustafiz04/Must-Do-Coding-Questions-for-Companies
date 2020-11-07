import java.io.*;
import java.util.*;

class Equilibrium {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            EquilibriumPoint obj = new EquilibriumPoint();

            System.out.println(obj.equilibriumPoint(arr, n));
        }
    }
}


class EquilibriumPoint {
    public static int equilibriumPoint(long arr[], int n) {
        long sum = 0;
        long left_sum = 0;
        
        for(int i = 0; i<n; i++){
            sum += arr[i];
        }
        
        for(int i = 0; i<n; i++){
            sum -= arr[i];
            if( sum == left_sum )
                return i+1;
            
            left_sum += arr[i];
        }
        return -1;
    }
}