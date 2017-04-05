package book.karumanchi.ds.Tree.Questions;

import book.karumanchi.ds.Tree.BinaryTreeNode;
/*
 * http://www.geeksforgeeks.org/find-largest-subtree-having-identical-left-and-right-subtrees/
 */
public class LargetsIdenticalSubTree extends BinaryTreeNode {

	public LargetsIdenticalSubTree(int data) {
		super(data);
	}

	private static int largetEqualHeight=0;
	private static BinaryTreeNode rootOfEqualTree=null;
	private static void getLargestSubTreeRoot(BinaryTreeNode head) {
		if(head ==null){
			return;
		}
		if(head.getLeft() !=null && head.getRight() !=null && head.getLeft().getData()==head.getRight().getData()){
			int height=isEqualTree(head.getLeft(),head.getRight(), 0);
			if(height>largetEqualHeight){
				largetEqualHeight=height;
				rootOfEqualTree=head;
			}
		}
		getLargestSubTreeRoot(head.getLeft());
		getLargestSubTreeRoot(head.getRight());
		
	}
	
	private static int isEqualTree(BinaryTreeNode headleft, BinaryTreeNode headRight,int height) {
		if(headleft==null && headRight==null){
			return height;
		}
		if(headleft.getData() ==headRight.getData()){
			height=height+1;
			int leftHeight=isEqualTree(headleft.getLeft(),headRight.getLeft(),height);
			int rightHeight=isEqualTree(headleft.getRight(),headRight.getRight(),height);
			if(leftHeight == rightHeight){
				return leftHeight;
			}
		}
		return height;
		
	}
	 
	public static void main(String[] args) {
		BinaryTreeNode head=new BinaryTreeNode(50);
		BinaryTreeNode h1=new BinaryTreeNode(10);
		head.setLeft(h1);
		BinaryTreeNode h11=new BinaryTreeNode(5);
		BinaryTreeNode h12=new BinaryTreeNode(5);
		h1.setLeft(h11);
		h1.setRight(h12);
		BinaryTreeNode h2=new BinaryTreeNode(60);
		head.setRight(h2);
		BinaryTreeNode h21=new BinaryTreeNode(70);
		h2.setLeft(h21);
		BinaryTreeNode h211=new BinaryTreeNode(65);
		BinaryTreeNode h212=new BinaryTreeNode(80);
		h21.setLeft(h211);
		h21.setRight(h212);
		BinaryTreeNode h22=new BinaryTreeNode(70);
		h2.setRight(h22);
		BinaryTreeNode h221=new BinaryTreeNode(65);
		BinaryTreeNode h222=new BinaryTreeNode(80);
		h22.setLeft(h221);
		h22.setRight(h222);
		getLargestSubTreeRoot(head);
		System.out.println(rootOfEqualTree.getData()+" having height of equal tree " + largetEqualHeight);
	}

}
