package book.karumanchi.ds.Tree.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import book.karumanchi.ds.Tree.BinarySearchTree;
import book.karumanchi.ds.Tree.BinaryTreeNode;

public class KthSmallestNodeInBST extends BinarySearchTree{
	
	private static int val=0;
	public KthSmallestNodeInBST(int data) {
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
		int k=2;
		Queue sortedData=getKthSmallestNodeNonRecurssive(head,null);
		while(k>1){
			sortedData.poll();
			k--;
		}
		System.out.println(sortedData.poll());
		//Recursive method call
		entryPointForRecursiveMethod(head,2);
	}
	
	private static Queue getKthSmallestNodeNonRecurssive(BinaryTreeNode head,Queue<Integer> sortedData){
		if(sortedData==null){
			sortedData= new LinkedList<Integer>();
		}
		
		if(head==null ){
			return null;
		}
		getKthSmallestNodeNonRecurssive(head.getLeft(), sortedData);	
		sortedData.offer(head.getData());	
		getKthSmallestNodeNonRecurssive(head.getRight(), sortedData);	
		
		return sortedData;
	}
	
	//Recursive method
	private static void entryPointForRecursiveMethod(BinaryTreeNode head,int k){
		if(val==0){
			val =k-1;
		}
		getKthSmallestNodeRecurssive(head);
	}
	
	private static void getKthSmallestNodeRecurssive(BinaryTreeNode head){
		
		
		if(head==null){
			return ;
		}
		getKthSmallestNodeRecurssive(head.getLeft());	
		if(val ==0){
			System.out.println(head.getData());
		}
		val--;
		getKthSmallestNodeRecurssive(head.getRight());	
		
		return ;
	}

}
