package book.karumanchi.ds.Tree.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import book.karumanchi.ds.Tree.BinaryTreeNode;

public class Jigyasha extends BinaryTreeNode{

	private static int nodeCount=0;
	static int maxlevel = 0;
	public Jigyasha(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	/*
	 * Left view of a tree would be the first node at each level
	 * We can do a level order traversal and print first node at each level
	 */
	
	public static void printLeftView(BinaryTreeNode root)
	{
		if(root == null)
			return;
		
		printLeftViewUtil(root ,1);
	}
	public static void printLeftViewUtil(BinaryTreeNode root , int level)
	{
		if(root == null)
			return;
		if(level > maxlevel){
			System.out.println(root.getData());
			maxlevel= level;
		}

		printLeftViewUtil(root.getLeft() , level +1);
		printLeftViewUtil(root.getRight() , level +1);
		
	}
	
	public static boolean checkSiblings(BinaryTreeNode root , BinaryTreeNode root1,BinaryTreeNode root2){
		if(root == null)
			return false;
		if((root.getLeft() == root1 && root.getRight() == root2) || (root.getRight() == root1 && root.getLeft() == root2))
			return true;
		
		return checkSiblings(root.getLeft() , root1 , root2)||checkSiblings(root.getLeft() , root1 , root2);
	}
	
	public static void singleChild(BinaryTreeNode root){
		if(root == null)
			return ;
		
		if (root.getLeft()!= null && root.getRight() == null) 
				System.out.print(root.getLeft().getData() + " ");
		else if(root.getLeft() == null && root.getRight() != null)
			System.out.print(root.getRight().getData() + " ");
			
		singleChild(root.getLeft());
		singleChild(root.getRight());
	}
	
	public static boolean checkCousins(BinaryTreeNode root , BinaryTreeNode root1,BinaryTreeNode root2){
		if(root == null)
			return false;
		int level1 = getLevel(root , root1 , 1);
		int level2 = getLevel(root , root2 , 1);
		
		return (level1 == level2 && !checkSiblings(root,root1,root2));
		
		//return checkCousins(root.getLeft(),root1,root2) || checkCousins(root.getLeft(),root1,root2);
	}
	
	public static int getLevel(BinaryTreeNode root , BinaryTreeNode root1 , int level){
		if(root == null)
			return 0;
		if(root.getData() == root1.getData())
			return level;
		
	     int downlevel = getLevel(root.getLeft(),root1,level+1);
		 if(downlevel!=0)
			 return downlevel;
		 
		
		 downlevel =  getLevel(root.getRight(),root1,level+1);
			 return downlevel;
		
	}
	
	public static void printNodesAtLevel(BinaryTreeNode root , int level , int givenLevel){
		if (root == null)
			return;
		if(level == givenLevel)
			System.out.print(root.getData() + " ");
		printNodesAtLevel(root.getLeft(),level + 1,givenLevel);
		printNodesAtLevel(root.getRight(),level + 1,givenLevel);
	}
	
	public static int countNodesAtLevel(BinaryTreeNode root , int level , int givenLevel){
	
		if(root == null)
			return 0;
		if(level == givenLevel)
			nodeCount++;
		
		countNodesAtLevel(root.getLeft(),level + 1,givenLevel);
		countNodesAtLevel(root.getRight(),level + 1,givenLevel);
		return nodeCount;
	}
	
	/* Width is the maximum number of nodes present in a level
	 * out of all levels of a tree
	 */
	
	public static int getWidth(BinaryTreeNode root){
		if(root == null)
			return 0;
		
		int height =getHeight(root);
		int max = 0;
		for(int i=1;i<=height;i++)
		{
		 int nodeatlevel	= countNodesAtLevel(root , 1 , i);
		 nodeCount = 0;
		 if(nodeatlevel > max)
			 max = nodeatlevel;
		}
		return max;	
	}
	
	/*
	 * Width of a tree using queue
	 * Idea is to push child of all nodes at a particular level
	 * and then count the number of nodes in queue and update the final result.
	 */
	/*public static int getWidthIterative(BinaryTreeNode root){
		if(root == null)
			return 0;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		int max = 0;
		q.offer(root);
		while()
		
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root= new BinaryTreeNode(25);
		BinaryTreeNode child11= new BinaryTreeNode(2);
		BinaryTreeNode child12= new BinaryTreeNode(33);
		BinaryTreeNode child111= new BinaryTreeNode(4);
		BinaryTreeNode child1112= new BinaryTreeNode(55);
		BinaryTreeNode child121= new BinaryTreeNode(10);
		BinaryTreeNode child1212= new BinaryTreeNode(45);
		root.setLeft(child11);
		root.setRight(child12);
		child11.setLeft(child111);
		child111.setRight(child1112);
		child12.setLeft(child121);
		child121.setLeft(child1212);
		System.out.print(countNodesAtLevel(root , 1 ,4));
	}

}
