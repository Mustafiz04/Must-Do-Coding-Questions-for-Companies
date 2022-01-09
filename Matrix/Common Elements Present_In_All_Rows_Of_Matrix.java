import java.util.*;

public class Solution {
  public static ArrayList<Integer> findCommonElements(ArrayList<ArrayList<Integer>> mat) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    int row = mat.size();
    if (row == 0)
      return ans;
    int col = mat.get(0).size();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < col; i++) {
      map.put(mat.get(0).get(i), 1);
      if (row == 1) {
        ans.add(mat.get(0).get(i));
      }
    }

    for (int i = 1; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (map.get(mat.get(i).get(j)) != null && map.get(mat.get(i).get(j)) == i) {
          map.put(mat.get(i).get(j), i + 1);

          if (i == row - 1) {
            ans.add(mat.get(i).get(j));
          }
        }
      }
    }
    return ans;
  }
}
