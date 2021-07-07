import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] dp = new int[n1+1][n2+1];
		for(int i = n1 ; i >= 0 ; i--)
		{
		    for(int j = n2 ; j >= 0 ; j--)
		    {
		        if(i == n1 && j == n2)
		        {
		            dp[i][j] = 0 ;
		        }else if(i == n1){
		            dp[i][j] = (int)s2.charAt(j) + dp[i][j+1];
		        }else if(j == n2)
		        {
		             dp[i][j] = (int)s1.charAt(i) + dp[i+1][j];
		        }else{
		            char c1 = s1.charAt(i);
		            char c2 = s2.charAt(j);
		            if(c1 == c2)
		            {
		                dp[i][j] = dp[i+1][j+1];
		            }else{
		                dp[i][j] = Math.min((int)c1 + dp[i+1][j] , (int)c2 + dp[i][j+1]) ;
		            }
		        }
		    }
		}

		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}
