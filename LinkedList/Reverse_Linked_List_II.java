public class 92_Reverse_Linked_List_II {
  public static void main(String[] args){
    
  }

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode prev = null, curr = head;
    
    while( left > 1 ){
        prev = curr;
        curr = curr.next;
        left--;
        right--;
    }
    
    ListNode connection = prev, newEnd = curr;
    while( right > 0 ){
        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
        right--;
    }
    
    if( connection != null ){
        connection.next = prev;
    }else{
        head = prev;
    }
    
    newEnd.next = curr;
    return head;
  }
}
