package book.karumanchi.ds.Tree.Questions;

import book.karumanchi.ds.Tree.BinaryTreeNode;

public class SiblingAndCousinNodes extends BinaryTreeNode {

	public SiblingAndCousinNodes(int data) {
		super(data);
	}
	
	private static boolean isSiblings(BinaryTreeNode root , int k, int j) {
		boolean siblings=false;
		if(root==null){
			return siblings;
		}
		if(root.getLeft() !=null && root.getRight() !=null){
			if(root.getLeft().getData() ==k && root.getRight().getData() ==j || 
					root.getLeft().getData() ==j && root.getRight().getData() ==k){
				siblings=true;
				return siblings;
			}
			else if(root.getLeft().getData() ==k || root.getLeft().getData() ==j ||
					root.getLeft().getData() ==j && root.getRight().getData() ==k){
				return false;
			}
		}
		return isSiblings(root.getLeft(),k,j) || isSiblings(root.getRight(),k,j);
	}
	
	private static boolean isCousin(BinaryTreeNode root,int j,int k){
		if(!isSiblings(root, k, j)){
			if(getHeightOfNode(root,j,0) == getHeightOfNode(root,k,0)){
				return true;
			}
		}
		return false;
	}
	
	private static int getHeightOfNode(BinaryTreeNode root, int val,int h){
		int hl=0,hr=0;
		if(root ==null){
			return 0;
		}
		if(root.getData() ==val){
			return h;
		}
		if(root.getLeft() !=null){
			hl=getHeightOfNode(root.getLeft(),val,h+1);
		}
		if(root.getRight() !=null){
			hr=getHeightOfNode(root.getRight(),val,h+1);
		}
		return hl>hr?hl:hr;
	}

	public static void main(String[] args) {
		BinaryTreeNode root= new BinaryTreeNode(25);
		BinaryTreeNode child11= new BinaryTreeNode(2);
		BinaryTreeNode child12= new BinaryTreeNode(33);
		BinaryTreeNode child111= new BinaryTreeNode(4);
		BinaryTreeNode child1112= new BinaryTreeNode(55);
		BinaryTreeNode child121= new BinaryTreeNode(10);
		BinaryTreeNode child122= new BinaryTreeNode(20);
		BinaryTreeNode child1212= new BinaryTreeNode(45);
		root.setLeft(child11);
		root.setRight(child12);
		child11.setLeft(child111);
		child111.setRight(child1112);
		child12.setLeft(child121);
		child12.setRight(child122);
		child121.setLeft(child1212);
		System.out.println("The nodes are siblings "+isSiblings(root,10,20));
		System.out.println("The nodes are cousines "+isCousin(root,4,20));
	}

}
