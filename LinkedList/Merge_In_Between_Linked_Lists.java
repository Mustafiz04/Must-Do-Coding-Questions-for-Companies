public class Merge_In_Between_Linked_Lists {
  public static void main(String[] args) {
  }

  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode prev = null, curr = list1;
    while (curr != null && a > 0) {
      prev = curr;
      curr = curr.next;
      a--;
      b--;
    }
    ListNode next = curr.next;
    while (next != null && b > 0) {
      curr = next;
      next = next.next;
      b--;
    }

    ListNode last2 = list2;
    while (last2.next != null) {
      last2 = last2.next;
      b--;
    }
    if (prev == null) {
      list1 = list2;
    } else {
      prev.next = list2;
    }
    last2.next = next;

    return list1;
  }
}
