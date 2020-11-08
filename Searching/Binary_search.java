import java.util.*;

public class Binary_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int element = sc.nextInt();
            int index = binarySearch(arr, n, element);
            System.out.println(index);
        }
    }

    public static int binarySearch(int[] arr, int n, int ele){
        int left = 0;
        int right = n-1;

        while( left <= right ){
            int mid = (left + right)/2;

            if( arr[mid] == ele ){
                return mid;
            }else if(arr[mid] > ele){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

}
