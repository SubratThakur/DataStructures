package book.karumanchi.ds.Tree.Questions;

import book.karumanchi.ds.Tree.BinarySearchTree;
import book.karumanchi.ds.Tree.BinaryTreeNode;

public class GetNodeAtKLevelFromRoot extends BinarySearchTree {

	public GetNodeAtKLevelFromRoot(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	private static void getNodeAtKLevel(BinaryTreeNode head,int count, int level) {
		if(head==null){
			return;
		}
		if(head.getLeft() !=null  && count<level-1){
			getNodeAtKLevel(head.getLeft(),count+1,level);
		}
		if(head.getRight() !=null && count<level-1){
			getNodeAtKLevel(head.getRight(),count+1,level);
		}
		if(count==level-1){
			if(head.getLeft() !=null)
			System.out.println(head.getLeft().getData());
			if(head.getRight() !=null)
			System.out.println(head.getRight().getData());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				BinaryTreeNode head=new BinaryTreeNode(10);
				insert(head, 8);
				insert(head, 9);
				insert(head, 15);
				insert(head, 7);
				insert(head, 12);
				insert(head, 16);
				insert(head, 6);
				getNodeAtKLevel(head,0,3);
	}

}
