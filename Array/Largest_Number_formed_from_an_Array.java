public class LargestNumberFormedFromArray {
    public static void main(String[] args) {
        String[] arr = {"54", "546", "548", "60"};
        System.out.println(printLargest(arr));
    }


    public static String printLargest(String[] arr) {
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                String ij = arr[i] + arr[j];
                String ji = arr[j] + arr[i];
                
                if( Integer.parseInt(ji) > Integer.parseInt(ij) ){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        String result = "";
        for(int i = 0; i<n; i++){
            result += arr[i];
        }
        return result;
    }
}
