/**
 * 
 */
package book.karumanchi.ds.LinkedList;

/**
 * @author subratt
 *
 */
public class DoublyLinkedListNode {
	
	int data;
	SinglyLinkedListNode next,prev;

	/**
	 * 
	 */
	public DoublyLinkedListNode() {
		// TODO Auto-generated constructor stub
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SinglyLinkedListNode getNext() {
		return next;
	}

	public void setNext(SinglyLinkedListNode next) {
		this.next = next;
	}

	public SinglyLinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(SinglyLinkedListNode prev) {
		this.prev = prev;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
