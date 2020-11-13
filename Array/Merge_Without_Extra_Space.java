import java.util.*;
import java.io.*;

class Sorting{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int arr1[] = new int[n];
		    int arr2[] = new int[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    new MergeSort().merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}
class MergeSort{
    public static void merge(int arr1[], int arr2[], int n, int m) {
        for(int i = m - 1; i>= 0; i--){
            int j;
            int last = arr1[n-1];
            for(j = n-2; j>=0 && arr1[j] > arr2[i] ; j--){
                arr1[j+1] = arr1[j];
            }
            if( j != n-2 || last > arr2[i] ){
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}