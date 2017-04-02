package book.karumanchi.ds.Tree.Questions;

import book.karumanchi.ds.Tree.BinarySearchTree;
import book.karumanchi.ds.Tree.BinaryTreeNode;

public class CheckBinaryTree extends BinarySearchTree{

	

	public CheckBinaryTree(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

public static boolean checkBST(BinaryTreeNode root) {
        if(root ==null){
            return true;
        }
        if(root.getLeft()!=null && root.getRight() !=null){
            if(root.getData()> root.getLeft().getData() && root.getData()<root.getRight().getData()){
                return checkBSTLeft(root.getLeft(),root.getData()+1) && checkBSTRight(root.getRight(),root.getData()-1);
            }
        } else if(root.getLeft()==null && root.getRight() ==null){
            return true;
        }
        return false;
        
    }

private static boolean checkBSTLeft(BinaryTreeNode root,int min_max){
    if(root==null){
        return true;
    }
    if(root.getLeft()!=null && root.getRight() !=null){
            if(root.getData()> root.getLeft().getData() && min_max>root.getLeft().getData() && min_max>root.getRight().getData() && root.getData()<root.getRight().getData()){
                return checkBSTLeft(root.getLeft(),min_max+1) && checkBSTRight(root.getRight(),min_max-1);
            }
    }else if(root.getLeft()==null && root.getRight() ==null){
            return true;
    }
    else if(root.getLeft()!=null){
        return checkBSTLeft(root.getLeft(),min_max+1);
    }
    else{
        return checkBSTRight(root.getRight(),min_max-1);
    }
    return false;
}

private static boolean checkBSTRight(BinaryTreeNode root,int min_max){
    if(root==null){
        return true;
    }
    if(root.getLeft()!=null && root.getRight() !=null){
            if(root.getData()> root.getLeft().getData() && min_max<root.getLeft().getData() && min_max<root.getRight().getData() && root.getData()<root.getRight().getData()){
                return checkBSTLeft(root.getLeft(),min_max+1) && checkBSTRight(root.getRight(),min_max-1);
            }
    }else if(root.getLeft()==null && root.getRight() ==null){
            return true;
    }
    else if(root.getLeft()!=null){
        return checkBSTLeft(root.getLeft(),min_max+1);
    }
    else{
        return checkBSTRight(root.getRight(),min_max-1);
    }
    return false;
}
	/**
	 * @param args
	 */
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
		System.out.println(checkBST(head));
	}

}
