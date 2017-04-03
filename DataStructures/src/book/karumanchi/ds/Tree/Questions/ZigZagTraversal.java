/**
 * 
 */
package book.karumanchi.ds.Tree.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import book.karumanchi.ds.Tree.BinaryTreeNode;

/**
 * @author subratt
 *
 */
public class ZigZagTraversal extends BinaryTreeNode {

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
	
	/*public static void zigZagTraversalRecursive(BinaryTreeNode root,int level,boolean isrightToLeft){
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
		
				
	}*/
	
	public static void zigZagTraversalNonRecursive(BinaryTreeNode root,boolean isrightToLeft){
		Queue<BinaryTreeNode> listTraversal=new LinkedList<BinaryTreeNode>();
		if(root ==null){
			return;
		}
		listTraversal.offer(root);
		while(!listTraversal.isEmpty()){
			BinaryTreeNode btn=listTraversal.poll();
			System.out.print(btn.getData() + " -> ");
			if(isrightToLeft){
				if(btn.getLeft() !=null)
				listTraversal.offer(btn.getLeft());
				if(btn.getRight() !=null)
				listTraversal.offer(btn.getRight());
			}
			else{
				if(btn.getRight() !=null)
				listTraversal.offer(btn.getRight());
				if(btn.getLeft() !=null)
				listTraversal.offer(btn.getLeft());
			
			}
			isrightToLeft = !isrightToLeft;
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
		//System.out.println(getHeight(root));
        //System.out.println("Zigzag Tree traversal result (Recursive) :");
        zigZagTraversalRecursive(root);
       // zigZagTraversalNonRecursive(root,true);
	}

}
