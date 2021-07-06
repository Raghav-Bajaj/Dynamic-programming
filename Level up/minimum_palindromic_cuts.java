import java.io.*;
import java.util.*;

public class Main {

	public static int minPalindromicCut(String s) {
	boolean[][] dp = new boolean[s.length()][s.length()];
	for(int g = 0 ; g < s.length() ; g++)
	{
	    for(int i = 0 , j = g ; j < dp.length ; i++ , j++)
	    {
	        if(g== 0)
	        {
	            dp[i][j] = true ;
	        }else if(g == 1)
	        {
	           
	                dp[i][j] = s.charAt(i) == s.charAt(j) ;
	         
	        }else{
	            if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true )
	            {
	                dp[i][j] = true;
	            }else{
	                dp[i][j] = false ;
	            }
	        }
	    }
	}
	int[] res = new int[dp.length];
	res[0] = 0 ;
	for(int i = 1 ; i < res.length ; i++)
	{
	    if(dp[0][i])
	    {
	        res[i] = 0 ;
	    }else{
	        int min =  Integer.MAX_VALUE;
	        for(int j = i ; j >=1 ; j--)
	        {
	            if(dp[j][i])
	            {
	                if(res[j-1] < min)
	                {
	                    min = res[j-1] ;
	                }
	            }
	        }
	        res[i] = min +1 ;
	    }
	}

		return res[dp.length-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}
