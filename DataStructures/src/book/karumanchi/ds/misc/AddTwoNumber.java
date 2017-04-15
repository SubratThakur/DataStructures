package book.karumanchi.ds.misc;

public class AddTwoNumber {

	public static void main(String[] args) {
		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(9);
		ListNode l3= new ListNode(9);
		l2.next=l3;
		ListNode nl=addTwoNumbers(l1,l2);
		while(nl !=null){
			System.out.print(nl.val +" ,");
			nl=nl.next;
		}

	}
	
	
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int reminder=0;
	        ListNode lastNode=null;
	        ListNode head=null;
	            while(l1 !=null || l2 !=null){
	                int val=0;
	                if(l1 !=null)
	                val=l1.val;
	                if(l2 !=null)
	                val=val+l2.val;
	                if(reminder>0)
	                val= val+reminder;
	                if(val>9){
	                  reminder=1;
	                  val=val%10;
	                }
	                else{
	                   reminder=0; 
	                }
	                if(head==null){
	                    head=new ListNode(val);
	                    lastNode=head;
	                    l1=l1.next;
	                    l2=l2.next;
	                
	                }
	                else if(l1 !=null && l2 !=null){
	                    ListNode nextNode=new ListNode(val);
	                    lastNode.next=nextNode;
	                    lastNode=nextNode;
	                    l1=l1.next;
	                    l2=l2.next;
	                }
	                else if(l1 !=null){
	                     ListNode nextNode=new ListNode(val);
	                    lastNode.next=nextNode;
	                    lastNode=nextNode;
	                    l1=l1.next;
	                }
	                else if(l2 !=null){
	                    ListNode nextNode=new ListNode(val);
	                    lastNode.next=nextNode;
	                    lastNode=nextNode;
	                    l2=l2.next;
	                    
	                }
	            }
	            if(reminder >0){
	                   ListNode nextNode=new ListNode(reminder);
	                    lastNode.next=nextNode;
	                    lastNode=nextNode; 
	            }
	    
	        return head;
	        
	    }
	 
}
	
//Definition for singly-linked list.
		 class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
		  }


	 
