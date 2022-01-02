
// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

public class LRUDesign {

  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(read.readLine());

    while (t-- > 0) {

      int capacity = Integer.parseInt(read.readLine());
      int queries = Integer.parseInt(read.readLine());
      LRUCache cache = new LRUCache(capacity);
      String str[] = read.readLine().trim().split(" ");
      int len = str.length;
      int itr = 0;

      for (int i = 0; (i < queries) && (itr < len); i++) {
        String queryType = str[itr++];
        if (queryType.equals("SET")) {
          int key = Integer.parseInt(str[itr++]);
          int value = Integer.parseInt(str[itr++]);
          cache.set(key, value);
        }
        if (queryType.equals("GET")) {
          int key = Integer.parseInt(str[itr++]);
          System.out.print(cache.get(key) + " ");
        }
      }
      System.out.println();
    }
  }
}

class LRUCache {
  static int cap = 0;
  static HashMap<Integer, Integer> map;

  LRUCache(int cap) {
    this.cap = cap;
    map = new LinkedHashMap<>();
  }

  public static int get(int key) {
    if (map.containsKey(key)) {
      int val = map.get(key);
      map.remove(key);
      map.put(key, val);
      return val;
    }
    return -1;
  }

  public static void set(int key, int value) {
    if (map.containsKey(key)) {
      map.remove(key);
    } else if (map.size() == cap) {
      map.remove(map.entrySet().iterator().next().getKey());
    }
    map.put(key, value);
  }
}
