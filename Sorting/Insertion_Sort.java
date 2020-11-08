import java.util.*;

public class Insertion_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            RInsertionSort(arr, n);
            print(arr);
        }
    }

    // Interative
    public static void insertionSort(int[] arr, int n){
        for(int i = 1; i<n; i++){
            int key = arr[i];
            int j = i - 1;

            while( j >= 0 && arr[j] > key ){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    // Recurssive
    public static void RInsertionSort(int[] arr, int n){
        if( n <= 1 ){
            return;
        }

        RInsertionSort(arr, n-1);

        int key = arr[n-1];
        int j = n - 2;

        while( j >= 0 && arr[j] > key ){
            arr[j+1] = arr[j];
            j = j-1;
        }
        arr[j+1] = key;
    
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
