package book.karumanchi.ds.misc;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/#/description
//Input : "Let's take LeetCode contest"
//Output : "s'teL ekat edoCteeL tsetnoc"
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String reverseWords(String s) {
        String result=new String();
        String[] parts = s.split(" ");
        for(String str: parts){
            result+=new StringBuilder(str).reverse().toString() + " ";
        }
        return result.trim();
    }
}
