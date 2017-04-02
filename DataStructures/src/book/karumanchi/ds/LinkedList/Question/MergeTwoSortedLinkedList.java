package book.karumanchi.ds.LinkedList.Question;

import book.karumanchi.ds.LinkedList.SinglyLinkedListNode;

public class MergeTwoSortedLinkedList extends SinglyLinkedListNode {

	
	public MergeTwoSortedLinkedList(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public static SinglyLinkedListNode MergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method 
		SinglyLinkedListNode temp;
	    if(headA ==null){
	        return headB;
	    }
	    if(headB ==null){
	        return headA;
	    }
	    SinglyLinkedListNode head = headA;
	    if(headA.getData() < headB.getData())
	        head = headA;
	    else
	        {
	        head = headB;
	        headB = headA;
	        headA = head;
	        }
	   // Node prev = headA;
	    
	    while(headA.getNext() != null && headB != null)
	        {
	          if(headA.getNext().getData() > headB.getData())
	              {
	               temp = headA.getNext();
	               headA.setNext(headB);
	               headB = headB.getNext();
	               headA.getNext().setNext(temp);
	              }
	         headA = headA.getNext();
	        }
	    if (headA.getNext() == null)
	        headA.setNext(headB);
	        return head;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SinglyLinkedListNode headA=new SinglyLinkedListNode(1);
		addNodeAtLast(headA, 5);
		addNodeAtLast(headA, 7);
		addNodeAtLast(headA, 9);
		addNodeAtLast(headA, 13);
		addNodeAtLast(headA, 18);
		
		SinglyLinkedListNode headB=new SinglyLinkedListNode(4);
		addNodeAtLast(headB, 6);
		addNodeAtLast(headB, 8);
		addNodeAtLast(headB, 10);
		addNodeAtLast(headB, 19);
		
		printLinkedList(MergeLists(headA, headB));

	}

}
