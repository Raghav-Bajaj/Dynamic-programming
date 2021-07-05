import java.io.*;
import java.util.*;

public class Main {

	public static boolean solution(String s, String p) {
	boolean[][] dp = new boolean[p.length()+1][s.length()+1];
	for(int i = 0  ; i < dp.length ; i++)
	{
	    for(int j = 0 ; j < dp[0].length ; j++)
	    {
	        if(i == 0 && j == 0)
	        {
	            dp[i][j] = true ;
	        }else if(i == 0)
	        {
	            dp[i][j] = false ;
	        }else if(j == 0)
	        {
	            char ch = p.charAt(i-1);
	            if(ch == '*')
	            {
	                dp[i][j] = dp[i-2][j];
	            }else{
	                dp[i][j] = false ;
	            }
	        }else{
	            char a = p.charAt(i-1);
	            char b = s.charAt(j-1);
	            if(a == '.')
	            {
	                dp[i][j] = dp[i-1][j-1];
	            }else if(a == '*')
	            {
	                 dp[i][j] = dp[i-2][j];
	                  char c = p.charAt(i-2);
	                 if(c == b || c=='.')
	                 {
	                     dp[i][j] = dp[i][j] || dp[i][j-1];
	                 }
	                
	            }else if(a == b)
	            {
	                  dp[i][j] = dp[i-1][j-1];
	                
	            }else{
	                dp[i][j] = false ;
	            }
	        }
	    }
	}
		
		return dp[p.length()][s.length()] ;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
