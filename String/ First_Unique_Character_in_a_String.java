package String;

public class First_Unique_Character_in_a_String {
  public static void main(String[] args) {

  }

  class Pair {
    int count;
    int index;

    Pair(int index) {
      this.count = 1;
      this.index = index;
    }

    void increaseCount() {
      this.count += 1;
    }
  }

  public int firstUniqChar(String s) {
    int n = s.length();
    HashMap<Character, Pair> map = new HashMap<Character, Pair>();

    for (int i = 0; i < n; i++) {
      char curr = s.charAt(i);
      if (!map.containsKey(curr)) {
        map.put(curr, new Pair(i));
      } else {
        map.get(curr).increaseCount();
      }
    }

    int result = Integer.MAX_VALUE;
    for (Map.Entry<Character, Pair> e : map.entrySet()) {
      int count = e.getValue().count;
      int index = e.getValue().index;
      if (count == 1 && index < result) {
        result = index;
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
