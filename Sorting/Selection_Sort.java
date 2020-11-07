import java.util.*;

public class Selection_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            selectionSort(arr, n);
            print(arr);
        }
    }

    public static void selectionSort(int[] arr, int n){
        for(int i = 0; i<n; i++){
            int minIndex = i;
            for(int j = i+1; j<n; j++){
                if( arr[j] < arr[minIndex] ) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
