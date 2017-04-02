package book.karumanchi.ds.LinkedList.Question;

import book.karumanchi.ds.LinkedList.SinglyLinkedListNode;

public class DetectLoopInLinkedList extends SinglyLinkedListNode{

	public DetectLoopInLinkedList(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	/*
	 * We can solve this problem with following methods:
	 * 1)Add a visited Node in LinkedListNode and add value true when you visit the node
	 * 2)Use hashTable and store address as key
	 * 3)Use slow and Fast pointer
	 */
	public static boolean isLoopInLinkedList(SinglyLinkedListNode head) {
		SinglyLinkedListNode slow=head;
		SinglyLinkedListNode fast=head;
		int count=0;
		while(fast !=null && fast.getNext() !=null){
			if(slow==fast && count>0){
				System.out.println("Loop Detected");
				return true;
			}
			slow=slow.getNext();
			fast=fast.getNext().getNext();
			count++;
		}
		System.out.println("No Loop Detected");
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//1 ->5-> 7-> 9-> 3-> 18->13 ->13
				SinglyLinkedListNode head=new SinglyLinkedListNode(1);
				addNodeAtLast(head, 5);
				addNodeAtLast(head, 7);
				addNodeAtLast(head, 9);
				addNodeAtLast(head, 3);
				addNodeAtLast(head, 18);
				addNodeAtLast(head, 13);
				addNodeAtLast(head, 13);
				isLoopInLinkedList(head);
				SinglyLinkedListNode lastNode = head.getLastNode(head);
				lastNode.setNext(head.getNext());
				isLoopInLinkedList(head);

	}

}
