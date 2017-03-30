package book.karumanchi.ds.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree extends BinaryTreeNode{
	
	private int data;
	private BinarySearchTree left;
	private BinarySearchTree right;
	private int height;

	public BinarySearchTree(int data) {
		super(data);
		this.data=data;
		this.left=null;
		this.right=null;
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


	public static void insert(BinarySearchTree head,int data){
		BinarySearchTree newNode= new BinarySearchTree(data);
		if(head ==null ){
			head = new BinarySearchTree (data);
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