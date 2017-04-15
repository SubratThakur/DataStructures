package book.karumanchi.ds.misc;

import java.util.HashMap;

public class LengthOfLongestSubstring {
	private static int max=0;
    private static int lengthOfLongestSubstring(String s) {
        int count=0;
        HashMap key=new HashMap();
        int i=0;
        while(i<s.length()){
            if(key.get(s.charAt(i)) !=null){
                if(count>max){
                    max=count;
                }   
            key=new HashMap();
            key.put(s.charAt(i),1);
            count=1;
            }
            else{
                key.put(s.charAt(i),1);
                count++;
            }
            i++;
        }
        if(count>max){
        	max=count;
        }
        return max;
    }
	public static void main(String[] args) {
		String test="dvdf";
		System.out.println(lengthOfLongestSubstring(test));
		

	}

}
