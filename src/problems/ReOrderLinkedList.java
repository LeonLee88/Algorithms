package problems;

public class ReOrderLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7};
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for(int i=0;i<array.length;i++){
			cur.next = new ListNode(array[i]);
			cur = cur.next;
		}
		Solution reorder = new Solution();
		System.out.print(reorder.reorder(dummy.next));
	}

}


class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

class Solution {
  public ListNode reorder(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode mid = middleNode(head);
    ListNode one = head;
    ListNode two = mid.next;
    mid.next = null;
    return merge(one, reverse(two));
  }
  
  public ListNode middleNode(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.next;
  }
  
  public ListNode reverse(ListNode head){
    if(head == null || head.next == null) {
      return head;
    }
    
    ListNode prev = null;
    ListNode cur = head;
    while(cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    
    return prev;
  }
  
  public ListNode merge(ListNode one, ListNode two){
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while(one != null && two != null) {
      cur.next = one;
      one = one.next;
      cur.next.next = two;
      two = two.next;
      cur = cur.next.next;
    }
    
    if(one != null) {
      cur.next = one;
    } else {
      cur.next = two;
    }
    return dummy.next;
  }
}

