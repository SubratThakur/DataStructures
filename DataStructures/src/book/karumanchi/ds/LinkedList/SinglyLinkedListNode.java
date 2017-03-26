/**
 * 
 */
package book.karumanchi.ds.LinkedList;

/**
 * @author subratt
 *
 */
public class SinglyLinkedListNode {
	
	int data;
	SinglyLinkedListNode next;

	/**
	 * 
	 */
	public SinglyLinkedListNode(int data) {
		this.data=data;
		this.next=null;
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
	
	public static int length(SinglyLinkedListNode head) {
		int length=0;
		if(head==null){
		return length;	
		}
		while(head.getNext() != null){
			head=head.getNext();
			length++;
		}
		return length;
	}
	
	public static void addNode(SinglyLinkedListNode head , int data){
		if(head==null){
			head=	new SinglyLinkedListNode(data);
		}
		else{
			while(head.getNext() != null){
				head=head.getNext();
			}	
			SinglyLinkedListNode node=new SinglyLinkedListNode(data);
			head.setNext(node);
		}
	}
	
	public static void deleteNode(SinglyLinkedListNode head , int data) throws RuntimeException {
		if(head==null){
			throw new RuntimeException("LinkedList is empty"); 
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}