package book.karumanchi.ds.Tree.Questions;

import book.karumanchi.ds.Tree.BinarySearchTree;

public class InorderSuccessorAndPredeseccor extends BinarySearchTree {

	
	public InorderSuccessorAndPredeseccor(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	//get min from right subtree or just previous 
	public static int getInorderSuccessor (BinarySearchTree head,int data){
		int inorderSuccessor= -1;
		if(head ==null){
			return 0;
		}
		if(head.getData()>data){
			if(head.getLeft() ==null ){
				throw new RuntimeException("Data not available in tree");				
			}
			else{
				inorderSuccessor=getInorderSuccessor(head.getLeft(),data);
			}
		}
		else if(head.getData() <data){
			if(head.getRight() ==null ){
				throw new RuntimeException("Data not available in tree");				
			}
			else{
				inorderSuccessor=getInorderSuccessor(head.getRight(),data);	
			}
		}else if(head.getData() ==data){
			if(head.getRight() !=null){
			inorderSuccessor=getMinInBinarySearchTree(head.getRight());
			}
		}
		if(head.getData()> data && (inorderSuccessor ==-1 ||inorderSuccessor>head.getData())){
			inorderSuccessor=head.getData();
		}
		return inorderSuccessor;		
	}
	
	public static int getInorderPredecessor(BinarySearchTree head,int data) {
		int inorderPredecessor= -1;
		if(head ==null){
			return inorderPredecessor;
		}
		if(head.getData()>data){
			if(head.getLeft() ==null ){
				throw new RuntimeException("Data not available in tree");				
			}
			else{
				inorderPredecessor=getInorderPredecessor(head.getLeft(),data);
			}
		}
		else if(head.getData() < data){
			if(head.getRight() ==null ){
				throw new RuntimeException("Data not available in tree");				
			}
			if(head.getRight() !=null){
				inorderPredecessor=getInorderPredecessor(head.getRight(),data);	
			}
		}else if(head.getData() ==data){
			if(head.getLeft() !=null){
				inorderPredecessor= getMaxInBinarySearchTree(head.getLeft());
			}			
		}
		if(head.getData()<data && (inorderPredecessor ==-1 ||inorderPredecessor<head.getData())){
			inorderPredecessor=head.getData();
		}
		return inorderPredecessor;
	}

	private static int getMinInBinarySearchTree(BinarySearchTree head) {
		if(head.getLeft() ==null){
			return head.getData();
		}
		return getMinInBinarySearchTree(head.getLeft());
	}
	
	private static int getMaxInBinarySearchTree (BinarySearchTree head) {
		if(head.getRight() ==null){
			return head.getData();
		}
		return getMaxInBinarySearchTree(head.getRight());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree head=new BinarySearchTree(10);
		insert(head, 8);
		insert(head, 9);
		insert(head, 15);
		insert(head, 7);
		insert(head, 12);
		insert(head, 16);
		insert(head, 6);
		System.out.println("Inorder Traversal for tree is" +getInorderTraversal(head,null));
		System.out.println("Get Minimum for tree is " +getMinInBinarySearchTree(head));
		System.out.println("Get maximum for tree is " +getMaxInBinarySearchTree(head));
		System.out.println(getInorderSuccessor(head, 15));
		System.out.println(getInorderSuccessor(head, 9));
		//System.out.println(getInorderPredecessor(head, 15));
		//System.out.println(getInorderPredecessor(head, 10));
	}

}
