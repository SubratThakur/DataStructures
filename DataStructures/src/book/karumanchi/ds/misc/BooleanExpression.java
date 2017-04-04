package book.karumanchi.ds.misc;

import java.util.Scanner;

public class BooleanExpression {

	private static int[] inputArr=null;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
        int maxResult=0;
        inputArr= new int[input];
        for(int i=0;i<input;i++){
            inputArr[i]=sc.nextInt();
        }
        for(int i=0;i<input;i++){
           for(int j=1;j<input;j++){
              int[] minTwo=getMinValue(i,j);
               int result=getExpression(minTwo[0],minTwo[1]);
               if(result > maxResult){
                   maxResult=result;
               }
           }            
        }
        System.out.println(maxResult);
    }
    
    private static int getExpression(int m1,int m2){
        return (((m1&m2)^(m1|m2))&(m1^m2));
    }
    
    private static int[] getMinValue(int i,int j){
        int[] minTwo = new int[2];
        for(;i<j;i++) {
            if(minTwo[0]>=0 || minTwo[0]>inputArr[i]){
                int temp=minTwo[0];                
                minTwo[1]=minTwo[0];
                minTwo[0]=inputArr[i];
            }
            else if(minTwo[1]>=0 || minTwo[1]>inputArr[i]){
                minTwo[1]=inputArr[i];
            }
        }
       return minTwo; 
    }

}
