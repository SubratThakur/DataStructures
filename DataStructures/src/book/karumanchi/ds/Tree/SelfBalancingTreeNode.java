package book.karumanchi.ds.Tree;

public class SelfBalancingTreeNode {
	private int data;
	int height;
	private SelfBalancingTreeNode left,right;
	

	public SelfBalancingTreeNode(int data) {
		super();
		this.data = data;
		this.height=1;
		this.left = null;
		this.right = null;
	}
	
	
	
	public int getData() {
		return data;
	}



	public void setData(int data) {
		this.data = data;
	}



	public SelfBalancingTreeNode getLeft() {
		return left;
	}



	public void setLeft(SelfBalancingTreeNode left) {
		this.left = left;
	}



	public SelfBalancingTreeNode getRight() {
		return right;
	}



	public void setRight(SelfBalancingTreeNode right) {
		this.right = right;
	}
	
	private static int height(SelfBalancingTreeNode node){
		if(node== null){
			return 0;
		}
		return node.height;
	}
	
	private static int max(int i,int j){
		return i>j?i:j;
	}
	
	private static int getBalance(SelfBalancingTreeNode node){
		return height(node.getLeft())-height(node.getRight());
	}
	
	public static SelfBalancingTreeNode insert(SelfBalancingTreeNode head,int val){
		if(head ==null){
			head=new SelfBalancingTreeNode(val);
			return head;
		}
		if(val<head.getData()){
			head.setLeft(insert(head.getLeft(),val));
		}
		if(val>head.getData()){
			head.setRight(insert(head.getRight(),val));
		}
		else{
			return head;
		}
		
		if(head.getLeft() !=null && head.getRight() !=null )
		head.height=max(height(head.getLeft()),height(head.getRight()))+1;
		
		int balance=getBalance(head);
		//Left Left Case -Right Rotation
		if(balance>1 && head.getLeft().getData()>val){
			return rightRotate(head);
			
		}
		//Left Right Case -Left Rotation + Right Rotation
		if(balance >1 && head.getLeft().getData()<val){
			head.setLeft(leftRotate(head.getLeft()));
			return rightRotate(head);
		}
		//If Right left Case -Left Rotation
		if(balance<-1 && head.getRight().getData()>val){
			head.setRight(rightRotate(head.getRight()));
			return leftRotate(head);
			
			
		}
		//If Right Right Case - Right Rotation + Left Rotation
		if(balance <-1 && head.getRight().getData()<val){
			return leftRotate(head);
		}
		
		return head;
	}
	
	private static SelfBalancingTreeNode rightRotate(SelfBalancingTreeNode head){
		SelfBalancingTreeNode nNode=head.getLeft();
		SelfBalancingTreeNode temp=nNode.getRight();
		if(temp !=null)
		nNode.setRight(head);
		head.setLeft(temp);
		return nNode;
	}
	
	private static SelfBalancingTreeNode leftRotate(SelfBalancingTreeNode head){
		SelfBalancingTreeNode nNode=head.getRight();
		SelfBalancingTreeNode temp=nNode.getLeft();
		if(nNode !=null)
		nNode.setLeft(head);
		head.setRight(temp);
		return nNode;
	}
		

	public static void main(String[] args) {
		SelfBalancingTreeNode head=new SelfBalancingTreeNode(50);
		System.out.println(insert(head,60).getData());
		System.out.println(insert(head,70).getData());
		System.out.println(insert(head,80).getData());
		System.out.println(insert(head,75).getData());

	}

}
