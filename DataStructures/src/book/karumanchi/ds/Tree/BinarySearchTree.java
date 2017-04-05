package book.karumanchi.ds.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	public static List<Integer> getInorderTraversalNonRecursive(BinaryTreeNode root) {
		if(root == null){
			return null;
		}
		List<Integer> res=new ArrayList<Integer>();
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		BinaryTreeNode currentNode=root;
		s.push(root);
		boolean done=true;
		while(!s.isEmpty()){
			if(currentNode !=null){
				if(currentNode.getLeft() !=null)
				s.push(currentNode.getLeft());
				currentNode=currentNode.getLeft();
			}else{
				
				currentNode=s.pop();
				res.add(currentNode.getData());
				if(currentNode.getRight() !=null)
				s.push(currentNode.getRight());
				currentNode=currentNode.getRight();
				
			}
		}
		return res;		
		
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
		System.out.println(getInorderTraversalNonRecursive(head).toString());
	}
	/*
	 * Delete node from Binary Search tree requires inorderSuccessor or InorderPrdeseccor 
	 * So deleteNode function is written in InorderSuccessorAndPredeseccor Class.
	
	*/

}
