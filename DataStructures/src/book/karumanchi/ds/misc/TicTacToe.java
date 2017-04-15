package book.karumanchi.ds.misc;

import java.util.Arrays;
import java.util.Random;

public class TicTacToe {
 private static String[][] tictacToe=new String[3][3];
 private static int count=0;
 private static boolean chance=true;
 private static void insertValueInTable(){
	 while(count<10){
		 int firstIndex=getRandomIndex();
		 int nextIndex=getRandomIndex();
		 if(tictacToe[firstIndex][nextIndex] == "?"){
			 if(chance){
			 tictacToe[firstIndex][nextIndex]="X"; 
			 }else{
				 tictacToe[firstIndex][nextIndex]="O"; 
			 }
			 chance=!chance;
			 count++;
		 }
		 
		 if(checkResult()){
			 System.out.println("Match finished with win");
			 break;
		 }
		 if(count==9){
			 System.out.println("Match finished without win");
			 break;
		 }
	 }
 }
 
 /*
  * This method generate Input between 0 to 2;
  * 
  */
 private static int getRandomIndex(){
	 Random rand = new Random();
	 int x = rand.nextInt(3);
	 return x;
 }
 
 private static boolean checkResult(){
	 for(int i=0;i<3;i++){
		 if(tictacToe[i][1] !="?" && tictacToe[i][1]==tictacToe[i][0] && tictacToe[i][2]==tictacToe[i][0]){
			 return true;
		 }
		 if(tictacToe[0][i] !="?" && tictacToe[0][i]==tictacToe[1][i] && tictacToe[0][i]==tictacToe[2][i]){
			 return true;
		 }
		 if(tictacToe[0][0] !="?" && tictacToe[0][0]==tictacToe[1][1] && tictacToe[0][0]==tictacToe[2][2]){
			return true; 
		 }
		 if(tictacToe[0][2] !="?" && tictacToe[0][2]==tictacToe[1][1] && tictacToe[0][2]==tictacToe[2][0]){
				return true; 
		 }
	 }
	 return false;
 }
 
 public static void main(String [] args){
	 Arrays.fill(tictacToe[0], "?");
	 Arrays.fill(tictacToe[1], "?");
	 Arrays.fill(tictacToe[2], "?");
	 insertValueInTable();
	 for(int i=0;i<3;i++){
		 for(int j=0;j<3;j++){
			 System.out.print(tictacToe[i][j] + "  ");
		 }
		 System.out.println();
	 }
 }
}
