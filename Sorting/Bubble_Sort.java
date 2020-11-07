import java.util.*;

public class Bubble_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            RBubbleSort(arr, n);
            print(arr);
        }
    }

    // Iterative
    public static void bubbleSort(int[] arr, int n){
        for(int i = 0; i<n-1; i++){
            for(int j = 0; j<n-1-i; j++){
                if( arr[j] > arr[j+1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Recurssive
    public static void RBubbleSort(int[] arr, int n) {
        if( n == 1 ){
            return;
        }
        for(int i = 0; i<n-1; i++){
            if( arr[i] > arr[i+1] ){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        bubbleSort(arr, n-1);
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
