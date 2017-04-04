package book.karumanchi.ds.Tree.Questions;

import java.util.ArrayList;
import java.util.List;

import book.karumanchi.ds.Tree.BinaryTreeNode;

public class DistanceBetweenTwoNode extends BinaryTreeNode {

	public DistanceBetweenTwoNode(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	static Object[] pathToK=null;
	static Object[] pathToL=null;
	public static void main(String[] args) {
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
		getDistanceBetweenTwoNode(root,4,33,null);
		if(pathToK.length >0 && pathToL.length >0){
			int i=0;
			int length=pathToK.length>pathToL.length?pathToL.length:pathToK.length;
			while(length>i && pathToK[i].equals(pathToL[i])){
				i++;
			}
			int distance=(pathToK.length-i)+(pathToL.length-i);
			System.out.println("The distance between nodes "+distance);
		}else{
			System.out.println("Node not found");
		}
	}
	
	private static void getDistanceBetweenTwoNode(BinaryTreeNode head,int k, int L,List<Integer> path) {
		if(path==null)
		path=new ArrayList<Integer>();
		if(head==null){
			return;
		}
		if(head.getData()==k){
			pathToK=path.toArray();
		}
		if(head.getData()==L){
			pathToL=path.toArray();
		}
		if(pathToL !=null && pathToK !=null){
			return;
		}
		if(head.getLeft() !=null){
		path.add(1);
		getDistanceBetweenTwoNode(head.getLeft(),k,L,path);
		
		}
		if(head.getRight() !=null){
		path.add(0);
		getDistanceBetweenTwoNode(head.getRight(), k, L,path);
		
		}
		path.remove(path.size()-1);
		return;
		
	}

}
