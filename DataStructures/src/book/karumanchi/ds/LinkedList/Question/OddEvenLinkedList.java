package book.karumanchi.ds.LinkedList.Question;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		//1->2->3->4->5
		ListNode l1= new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(3);
		l1.next.next.next=new ListNode(4);
		l1.next.next.next.next=new ListNode(5);
		ListNode head=oddEvenList(l1);
		while(head !=null){
			System.out.print(head.val +" ,");
			head=head.next;
		}
	}
	
	private static ListNode oddEvenList(ListNode head) {
        ListNode originalhead=head,originalNext=null,headOdd=null,headEven=null;
        if(head !=null){
            originalNext=head.next;
            headOdd=originalhead;
            headEven=originalNext;
            while(headOdd !=null && headEven !=null){
                headOdd.next=headEven.next;
                if(headOdd.next !=null){
                headOdd=headOdd.next;
                }
                headEven.next=headOdd.next;
                headEven=headEven.next;
                }
            headOdd.next=originalNext;
        }
    return originalhead;
}

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
