package data_structures;

public class LinkedListQueue {
	ListNode head;
	ListNode tail;
	int size;
	
	public LinkedListQueue(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public void offer(int num) {
		ListNode node = new ListNode(num);
		if(head == null) {
			head = node;
		}
		tail.next = node;
		tail = node;
		size++;
	}
	
	public Integer poll() {
		if(size == 0){
			return null;
		}
		int result = head.val;
		head = head.next;
		size--;
		return result;
	}
	
	public Integer peek(){
		if(size == 0){
			return null;
		}
		return head.val;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
}
