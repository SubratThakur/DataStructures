package book.karumanchi.ds.misc;

import java.util.Scanner;

/*
 * 
 * Alexa has two stacks of non-negative integers, stack A and stack B where index 0 denotes the top of the stack. Alexa challenges Nick to play the following game:

In each move, Nick can remove one integer from the top of either stack A or stack B.
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.
Given , , and  for  games, find the maximum possible score Nick can achieve (i.e., the maximum number of integers he can remove without being disqualified) during each game and print it on a new line.

Input Format

The first line contains an integer,  (the number of games). The  subsequent lines describe each game in the following format:

The first line contains three space-seperated integers describing the respective values of  (the number of integers in stack ),  (the number of integers in stack ), and  (the number that the sum of the integers removed from the two stacks cannot exceed).
The second line contains  space-seperated integers describing the respective values of .
The third line contains  space-seperated integers describing the respective values of .


 * Sample Input 0

1 number of Games
5 Number of element in first stack 4 number of element in Second stack  10 limit
4 2 4 6 1  Stack value
2 1 8 5 Second stack value
Sample Output 
4
 */
public class GameOfStack {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            getMaxCountOfIteration(a,b,x);
        }
    }
    
    private static void getMaxCountOfIteration(int[]a, int[] b,int max){
        int aIndex=0,bIndex=0,runTotal=0,count=0;
        while(runTotal<max){
	        if(a[aIndex]>b[bIndex]){
	            if(b[bIndex]<max || b[bIndex]+runTotal<max){
	                count++;
	                runTotal =runTotal+b[bIndex];
	                bIndex++;
	            }
	            else{
	                System.out.print(count);
	                return;
	            }
	            
	        }
	        else{
	            if(a[aIndex]<max || a[aIndex]+runTotal<max){
	                count++;
	                runTotal =runTotal + a[aIndex];
	                aIndex++;
	            }
	            else{
	                System.out.print(count);
	                return;
	            }
	        }
        }
    }
}
