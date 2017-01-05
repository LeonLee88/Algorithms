package problems;

public class selectionSortLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectionSortLinkedList sort = new selectionSortLinkedList();
		// TODO Auto-generated method stub
		int[] array = {4,3,2,1};
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for(int i=0;i<array.length;i++){
			cur.next = new ListNode(array[i]);
			cur = cur.next;
		}
		sort.selectionSort(dummy.next);
	}

	public ListNode selectionSort(ListNode head) {
	    if(head == null || head.next == null) return head;

	    ListNode dummy = new ListNode(0);
	    ListNode tail = dummy; // tail of sorted result
	    ListNode cur = head;
	    
	    while(cur != null) {
	      ListNode[] result = retrieveMinNode(cur);
	      tail.next = result[0]; // min node
	      cur = result[1];// new head of original list
	      tail = tail.next;
	    }
	    return dummy.next;
	  }
	  
	  public ListNode[] retrieveMinNode(ListNode head) {
	    ListNode[] result = new ListNode[2];
	    if(head.next == null){
	      result[0] = head;
	      result[1] = null;
	    }
	    ListNode dummy = new ListNode(0);// dummy node
	    dummy.next = head;
	    ListNode min = head;
	    ListNode minPrev = dummy;
	    ListNode prev = head; // previous node of head
	    ListNode cur = head.next; // head will move to the end
	    while(cur != null) {
	      if(min.value > cur.value){
	        minPrev = prev;
	        min = cur;
	      }
	      prev = cur;
	      cur = cur.next;
	    }
	    minPrev.next = min.next; // drop min node from the list
	    min.next = null;
	    result[0] = min;
	    result[1] = dummy.next; // min node and new head of original list
	    return result;
	  }
}
