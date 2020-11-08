import java.util.*;

public class Linear_Search {
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
            int index = linearSearch(arr, n, element);
            System.out.println(index);
        }
    }

    public static int linearSearch(int[] arr, int n, int ele){
        for(int i = 0; i< n; i++){
            if( arr[i] == ele ){
                return i;
            }
        }
        return -1;
    }

}
