package book.karumanchi.ds.Tree;

public class SelfBalancingTreeNode  {
	int data;
	int height;
	SelfBalancingTreeNode left;
	SelfBalancingTreeNode right;

	public SelfBalancingTreeNode(int data) {
		this.data=data;
		this.height=1;
	}
	
	public static SelfBalancingTreeNode insert(SelfBalancingTreeNode head,SelfBalancingTreeNode parent,int val){
		if(parent ==null){
			head=new SelfBalancingTreeNode(val);
			parent=head;
			return head;
		}
		
		return parent;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
