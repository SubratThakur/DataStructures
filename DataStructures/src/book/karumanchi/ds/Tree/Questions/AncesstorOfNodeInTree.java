package book.karumanchi.ds.Tree.Questions;

import java.util.Stack;

import book.karumanchi.ds.Tree.BinaryTreeNode;

public class AncesstorOfNodeInTree extends BinaryTreeNode {
	
	private static boolean found=false;

	public AncesstorOfNodeInTree(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/*BinaryTreeNode head=new BinaryTreeNode(50);
		BinaryTreeNode h1=new BinaryTreeNode(10);
		head.setLeft(h1);
		BinaryTreeNode h11=new BinaryTreeNode(5);
		BinaryTreeNode h12=new BinaryTreeNode(15);
		h1.setLeft(h11);
		h1.setRight(h12);
		BinaryTreeNode h2=new BinaryTreeNode(60);
		head.setRight(h2);
		BinaryTreeNode h21=new BinaryTreeNode(90);
		h2.setLeft(h21);
		BinaryTreeNode h211=new BinaryTreeNode(65);
		BinaryTreeNode h212=new BinaryTreeNode(82);
		h21.setLeft(h211);
		h21.setRight(h212);
		BinaryTreeNode h22=new BinaryTreeNode(70);
		h2.setRight(h22);
		BinaryTreeNode h221=new BinaryTreeNode(67);
		BinaryTreeNode h222=new BinaryTreeNode(80);
		h22.setLeft(h221);
		h22.setRight(h222);*/
		BinaryTreeNode head=new BinaryTreeNode(25);
		BinaryTreeNode h1=new BinaryTreeNode(2);
		head.setLeft(h1);
		BinaryTreeNode h11=new BinaryTreeNode(4);
		h1.setLeft(h11);
		BinaryTreeNode h112=new BinaryTreeNode(55);
		h11.setRight(h112);
		BinaryTreeNode h2=new BinaryTreeNode(33); 
		head.setLeft(h2);
		BinaryTreeNode h21=new BinaryTreeNode(10);
		h2.setLeft(h21);
		BinaryTreeNode h211=new BinaryTreeNode(45);
		h21.setLeft(h211);
		getAncesstorRecurssive(head,10);
		/*Stack result=getAncesstorOfNodeNonRecurssive(head,70);
		System.out.println(result.toString());*/

	}
	
	
	private static void getAncesstorRecurssive(BinaryTreeNode head,int key){
		if(head ==null){
			return;
		}
		if(head.getData() == key){
			found=true;
		}
		if(head.getLeft() !=null && !found){
			getAncesstorRecurssive(head.getLeft(),key);
		}
		if(head.getRight() !=null && !found){
			getAncesstorRecurssive(head.getRight(),key);
		}

		if(found && head.getData() !=key){
			System.out.print(head.getData() + " ,");
		}
	}
	
	private static Stack getAncesstorOfNodeNonRecurssive(BinaryTreeNode head,int key){
		Stack<BinaryTreeNode> ancesstor= new Stack<BinaryTreeNode>();
		BinaryTreeNode currentNode=head;
		ancesstor.push(head);
		while(head.getData() !=key && !ancesstor.isEmpty()){
				if(currentNode !=null){
					if(currentNode.getLeft() !=null)
						ancesstor.push(currentNode.getLeft());
					currentNode=currentNode.getLeft();
				}else{					
					currentNode=ancesstor.pop();
					if(currentNode.getRight() !=null)
					ancesstor.push(currentNode.getRight());
					currentNode=currentNode.getRight();
					
				}
		}
		return ancesstor;
	}

}
