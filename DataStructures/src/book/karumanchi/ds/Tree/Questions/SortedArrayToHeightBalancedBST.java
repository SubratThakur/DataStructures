package book.karumanchi.ds.Tree.Questions;

public class SortedArrayToHeightBalancedBST {

	
	public static void main(String [] args){
		int[] nums={1,2,3,4,5,6,7};
		preOrderTraversal(sortedArrayToBST(nums));
	}
	
	 public static TreeNode sortedArrayToBST(int[] nums) {
	         TreeNode root=null;
	        if(nums.length ==0){
	            return null;
	        }
	        if(nums.length ==1){
	            return new TreeNode(nums[0]);
	        }
	        else{
	            int mid=nums.length/2;
	            root=new TreeNode(nums[mid]);
	           root.left=createTreeFromArray(nums,0,mid-1); 
	           root.right=createTreeFromArray(nums,mid+1,nums.length-1);
	        }
	        return root;
	    }
	    
	    private static TreeNode createTreeFromArray(int [] nums,int min, int max){
	        TreeNode root=null;
	        if(min>max && max<0){
	            return new TreeNode(nums[min]);
	        }
	        else{
	            int mid=min+max/2;
	           root=new TreeNode(nums[mid]);
	           root.left=createTreeFromArray(nums,0,mid-1); 
	           root.right=createTreeFromArray(nums,mid+1,nums.length-1);
	        }
	        return root;
	    }
	    
	    private static void preOrderTraversal(TreeNode root){
	    if(root ==null){
	    	return;
	    }
	    System.out.println(root.val);
	    preOrderTraversal(root.left);
	    preOrderTraversal(root.right);
	    }
}

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	      }
