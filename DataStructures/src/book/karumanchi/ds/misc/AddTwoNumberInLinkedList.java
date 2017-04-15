package book.karumanchi.ds.misc;

public class AddTwoNumberInLinkedList {
	
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	l1=reverseList(l1);
	    	l2=reverseList(l2);
	        return AddTwoNumber.addTwoNumbers(l1, l2);
	    }
	    
	    private static ListNode reverseList(ListNode head) {
	    	if(head==null){
	    		return null;
	    	}
	    	if(head.next ==null){
	    		return head;
	    	}
	    	ListNode temp=null,next=null;
	    	while(head.next !=null){
	    		next=head.next;
	    		head.next=temp;
	    		temp=head;
	    		head=next;
	    	}
	    	head.next=temp;
	    	return head;
	    }
	    
	    
	    
	public static void main(String[] args) {
		//7->2->4->3
		ListNode l1= new ListNode(7);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		l1.next.next.next=new ListNode(3);
		//5->6->4
		ListNode l2= new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		ListNode nl=addTwoNumbers(l1,l2);
		while(nl !=null){
			System.out.print(nl.val +" ,");
			nl=nl.next;
		}
	}	

}


