import java.util.*;

public class Merge_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            mergeSort(arr, 0, n-1);
            print(arr);
        }
    }

    public static void mergeSort(int[] arr, int l, int r){
        if( l < r ){
            int mid = (l + r)/2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, r, mid);
        }
    }

    public static void merge(int[] arr, int l, int r, int mid){
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i<n1; i++){
            L[i] = arr[l + i];
        }
        for(int i = 0; i<n2; i++){
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = l;

        while( i < n1 && j < n2 ){
            if( L[i] <= R[j] ){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while( i < n1 ){
            arr[k] = L[i];
            i++;
            k++;
        }

        while( j < n2 ){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
