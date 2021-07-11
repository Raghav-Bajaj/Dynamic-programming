import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(String str) {
	int[][] dp = new int[str.length()][str.length()];
	for(int g = 0 ; g < dp.length ; g++)
	{
	    for(int i = 0 , j = g ; j < dp.length ; j++ ,i++)
	    {
	        if(g == 0)
	        {
	            dp[i][j] = 1 ;
	        }else if(g == 1){
	            if(str.charAt(i) == str.charAt(j))
	            {
	                dp[i][j] = 2 ;
	            }else{
	                dp[i][j] = 1 ;
	            }
	        }else{
	            if(str.charAt(i) == str.charAt(j))
	            {
	                dp[i][j] = 2 + dp[i+1][j-1] ;
	            }else{
	                dp[i][j] = Math.max(dp[i][j-1] , dp[i+1][j]);
	            }
	        }
	    }
	}


		return str.length() - dp[0][str.length()-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
}
