package book.karumanchi.ds.misc;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 *You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *Given nums = [2, 7, 11, 15], target = 9,Because nums[0] + nums[1] = 2 + 7 = 9,
 *return [0, 1].
*/
public class TwoSum {

	public TwoSum() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {2, 7, 11, 15};
		int target = 9;
		twoSum(nums,target);

	}
	
	public static int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        boolean found=true;
		for(int i=0;i<nums.length && found;i++){
		    for(int j=i+1;j<nums.length;j++){
    			if(nums[i]+nums[j]==target ){
    				result[0]=i;
    				result[1]=j;
    				found=false;
    				break;
    			}
		    }
		}
		return result;
    }
//No need of sorting method
	private static int[] sortArrayInAscending(int[] nums) {
		boolean swapped=true;
		for(int i=nums.length;i>0 && swapped;i--){
			swapped=false;
			for(int j=0;j>i;j++){
				if(nums[i]>nums[i+1]){
					int temp=nums[i];
					nums[i]=nums[i+1];
					nums[i+1]=nums[i];
					swapped=true;
				}
			}
		}
		return nums;
	}

}
