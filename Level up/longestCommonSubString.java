import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2){
	int[][] dp = new int[s1.length()+1][s2.length()+1];
	int max = Integer.MIN_VALUE ;
	for(int i = 1 ; i < dp.length ; i++ )
	{
	   for(int j = 1 ; j < dp[0].length ; j++ )
	   {
	       char c1  = s1.charAt(i-1);
	       char c2  = s2.charAt(j-1);
	       if(c1==c2)
	       {
	           dp[i][j] = dp[i-1][j-1] + 1 ;
	           if(dp[i][j] > max)
	           {
	               max = dp[i][j] ;
	           }
	       }
	   
	   }
	}
		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
