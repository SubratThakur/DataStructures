package book.karumanchi.ds.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree extends BinaryTreeNode{
	

	public BinarySearchTree(int data) {
		super(data);
	}

	public static void insert(BinaryTreeNode head,int data){
		BinaryTreeNode newNode= new BinaryTreeNode(data);
		if(head ==null ){
			head = new BinaryTreeNode (data);
			return;
		}
		if(head.getData()>data){
			if(head.getLeft() !=null){
			insert(head.getLeft(),data);
			}
			else{
			head.setLeft(newNode);
			}
			
		}
		else {
			if(head.getRight() !=null && head.getData()<data){
				insert(head.getRight(),data);
			}else{
			head.setRight(newNode);
			}
		}
	}
	
	public static String getInorderTraversal (BinaryTreeNode root, List<Integer> inorderTraversal){
		if(root == null){
			return null;
		}
		if(inorderTraversal==null){
			inorderTraversal= new ArrayList<Integer>();
		}

		BinaryTreeNode.getInorderTraversal(root.getLeft(), inorderTraversal);	
		inorderTraversal.add(root.getData());	
		BinaryTreeNode.getInorderTraversal(root.getRight(), inorderTraversal);	
		
		return inorderTraversal.toString();
		
	}
	
	
	/*
	 * Delete node from Binary Search tree requires inorderSuccessor or InorderPrdeseccor 
	 * So deleteNode function is written in InorderSuccessorAndPredeseccor Class.
	
	*/

}
