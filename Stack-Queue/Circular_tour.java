
// { Driver Code Starts
import java.util.*;

class First_Circular_tour {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      sc.nextLine();
      String str = sc.nextLine();
      String arr[] = str.split(" ");
      int p[] = new int[n];
      int d[] = new int[n];
      int j = 0;
      int k = 0;
      for (int i = 0; i < 2 * n; i++) {
        if (i % 2 == 0) {
          p[j] = Integer.parseInt(arr[i]);
          j++;
        } else {
          d[k] = Integer.parseInt(arr[i]);
          k++;
        }
      }

      System.out.println(new Solution().tour(p, d));
      t--;
    }
  }
}

class Solution {
  int tour(int petrol[], int distance[]) {
    int n = petrol.length;
    if (n == 0)
      return -1;
    int extraFuel = 0, requiredFuel = 0;
    int startingIndex = 0;
    for (int i = 0; i < n; i++) {
      extraFuel += petrol[i] - distance[i];
      if (extraFuel < 0) {
        requiredFuel += extraFuel;
        startingIndex = i + 1;
        extraFuel = 0;
      }
    }
    if (extraFuel + requiredFuel >= 0) {
      return startingIndex;
    }
    return -1;
  }
}