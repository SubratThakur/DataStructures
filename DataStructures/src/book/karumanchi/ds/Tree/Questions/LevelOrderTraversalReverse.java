/**
 * 
 */
package book.karumanchi.ds.Tree.Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import book.karumanchi.ds.Tree.BinaryTreeNode;

/**
 * @author subratt
 *
 */
public class LevelOrderTraversalReverse extends BinaryTreeNode{

	
	
	public LevelOrderTraversalReverse(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	/*
	 * The simplest and most efficient method to get LevelOrderTraversal in reverse order is by using Stack and Queue
	 */
	public static void getLevelOrderTraversalReverse(BinaryTreeNode root){
		Stack<Integer> reverseOrder= new Stack<Integer>();
		Queue<BinaryTreeNode> levelOrderQueue = new LinkedList<BinaryTreeNode>();
		if(root ==null){
			return;
		}
		levelOrderQueue.offer(root);
		reverseOrder.push(root.getData());
		while(!levelOrderQueue.isEmpty()){
			BinaryTreeNode node=levelOrderQueue.poll();
			if(node.getLeft() != null){
				levelOrderQueue.offer(node.getLeft());
				reverseOrder.push(node.getLeft().getData());
			}
			if(node.getRight() != null){
				levelOrderQueue.offer(node.getRight());
				reverseOrder.push(node.getRight().getData());
			}
		}
		
		while(!reverseOrder.isEmpty()){
			System.out.print(reverseOrder.pop() + "->");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode root= new BinaryTreeNode(1);
		BinaryTreeNode child11= new BinaryTreeNode(2);
		BinaryTreeNode child12= new BinaryTreeNode(3);
		BinaryTreeNode child111= new BinaryTreeNode(4);
		BinaryTreeNode child1112= new BinaryTreeNode(5);
		BinaryTreeNode child1111= new BinaryTreeNode (6);
		root.setLeft(child11);
		root.setRight(child12);
		child11.setLeft(child111);
		child111.setLeft(child1111);
		child111.setRight(child1112);
		getLevelOrderTraversalReverse(root);

	}

}
