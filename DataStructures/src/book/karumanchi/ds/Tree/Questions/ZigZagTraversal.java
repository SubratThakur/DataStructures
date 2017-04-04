/**
 * 
 */
package book.karumanchi.ds.Tree.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import book.karumanchi.ds.Tree.BinarySearchTree;
import book.karumanchi.ds.Tree.BinaryTreeNode;

/**
 * @author subratt
 *
 */
public class ZigZagTraversal extends BinarySearchTree {

	public ZigZagTraversal(int data) {
		super(data);
	}
	
	public static void zigZagTraversalRecursive(BinaryTreeNode root){
		int height = getHeight(root);
		boolean zigzagflag = false;
		for(int i=1;i <= height;i++)
		{
			printGivenLevelOrder(root , i , zigzagflag);
			zigzagflag = !zigzagflag;
       }
	}
	
	public static void printGivenLevelOrder(BinaryTreeNode root, int level ,boolean zigzagflag){
		  if(root == null)
			  return;
          if(level == 1)
          System.out.print(root.getData() + "->");
          
          else
          {
        	  if(zigzagflag){
        	  printGivenLevelOrder(root.getLeft() , level-1 , zigzagflag);
        	  printGivenLevelOrder(root.getRight() , level-1,zigzagflag);
        	  }
        	  else
        	  {
        		  printGivenLevelOrder(root.getRight() , level-1 ,zigzagflag);
            	  printGivenLevelOrder(root.getLeft() , level-1,zigzagflag);
        	  }
          }
          
	}
	
	public static void zigZagTraversalRecursive(BinaryTreeNode root,int level,boolean isrightToLeft){
		List<Integer> traversalPath =new ArrayList<Integer>();
		if(root ==null){
			return ;
		}
		isrightToLeft = !isrightToLeft;
		int height=getHeight(root);
		if(level == 0){
			System.out.print(root.getData() +"->");
		}

		for(;level<height;level++){
			if(isrightToLeft){
				zigZagTraversalRecursive(root.getLeft(),level,isrightToLeft);
				zigZagTraversalRecursive(root.getRight(),level,isrightToLeft);
			}
			else{
				zigZagTraversalRecursive(root.getRight(),level,isrightToLeft);
				zigZagTraversalRecursive(root.getLeft(),level,isrightToLeft);
			
			}
		}
		
				
	}
	
	public static void zigZagTraversalNonRecursive(BinaryTreeNode root){
		Stack<BinaryTreeNode> listTraversalStack1=new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> listTraversal=new Stack<BinaryTreeNode>();
		if(root ==null){
			return;
		}
		listTraversal.push(root);
		while(!listTraversal.isEmpty() || !listTraversalStack1.isEmpty()){
			
			while(!listTraversal.isEmpty()){
				BinaryTreeNode btn=listTraversal.pop();
				System.out.print(btn.getData() + "-> ");

				if(btn.getRight() !=null)
					listTraversalStack1.push(btn.getRight());
				if(btn.getLeft() !=null)
					listTraversalStack1.push(btn.getLeft());
			}

			while( !listTraversalStack1.isEmpty()){
				BinaryTreeNode btn=listTraversalStack1.pop();
				System.out.print(btn.getData() + "-> ");
					if(btn.getLeft() !=null)
						listTraversal.push(btn.getLeft());
					if(btn.getRight() !=null)
						listTraversal.push(btn.getRight());
				
				}
		}
	}
		

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode head=new BinaryTreeNode(10);
		insert(head, 8);
		insert(head, 9);
		insert(head, 15);
		insert(head, 7);
		insert(head, 12);
		insert(head, 16);
		insert(head, 6);
		insert(head, 13);
		insert(head, 11);
		//System.out.println(getHeight(root));
        //System.out.println("Zigzag Tree traversal result (Recursive) :");
		//10-8-15-16-12-9-7-6-11-13
		System.out.println("Inorder" + getInorderTraversal(head, null));
        zigZagTraversalRecursive(head,0,true);
        System.out.println("NonRecursive");
        zigZagTraversalNonRecursive(head);
	}

}
