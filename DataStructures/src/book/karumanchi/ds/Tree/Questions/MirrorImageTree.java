package book.karumanchi.ds.Tree.Questions;

import book.karumanchi.ds.Tree.BinarySearchTree;
import book.karumanchi.ds.Tree.BinaryTreeNode;

public class MirrorImageTree extends BinarySearchTree {

	public MirrorImageTree(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BinaryTreeNode head=new BinaryTreeNode(10);
		insert(head, 8);
		insert(head, 9);
		insert(head, 15);
		insert(head, 7);
		insert(head, 12);
		insert(head, 16);
		insert(head, 6);
		System.out.println(getInorderTraversal(head, null));
		getMirrorImageOfTree(head);
		System.out.println(getInorderTraversal(head, null));	

	}
	
	private static void getMirrorImageOfTree(BinaryTreeNode head){
		if(head ==null){
			return;
		}
		if(head.getLeft() !=null ){
			getMirrorImageOfTree(head.getLeft());
		}
		if(head.getRight() !=null){
			getMirrorImageOfTree(head.getRight());
		}
		BinaryTreeNode tmp=head.getLeft();
		head.setLeft(head.getRight());
		head.setRight(tmp);
		return;
	}

}
