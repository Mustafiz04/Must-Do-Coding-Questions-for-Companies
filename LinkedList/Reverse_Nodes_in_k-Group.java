public class Reverse_Nodes_in_k-Group{
  public static void main(String[] args) {

  }

  public ListNode reverseKGroup(ListNode head, int k) {
    int len = length(head);
    return reverse(head, k, len);
  }

  public ListNode reverse(ListNode head, int k, int len) {
    ListNode curr = head, next = null, prev = null;
    int count = 0;
    if (len < k) {
      return head;
    }
    while (curr != null && count < k) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }
    if (next != null) {
      head.next = reverse(next, k, len - k);
    }
    return prev;
  }

  public int length(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }
}
