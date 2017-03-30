package book.karumanchi.ds.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree extends BinaryTreeNode{
	
	int data;
	BinarySearchTree left;
	BinarySearchTree right;
	int height;

	public BinarySearchTree(int data) {
		super(data);
	}

	
	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public BinarySearchTree getLeft() {
		return left;
	}


	public void setLeft(BinarySearchTree left) {
		this.left = left;
	}


	public BinarySearchTree getRight() {
		return right;
	}


	public void setRight(BinarySearchTree right) {
		this.right = right;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public static void insert(BinaryTreeNode head,int data){
		BinaryTreeNode newNode= new BinaryTreeNode(data);
		if(head ==null ){
			head = new BinaryTreeNode (data);
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
			head.setLeft(newNode);
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
