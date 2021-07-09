import java.io.*;
import java.util.*;

public class Main {

	public static boolean isScrambleTab(String s1, String s2,int stl1 , int stl2 , int len , Boolean[][][] dp) {
		if(s1.substring(stl1 , stl1+len).equals(s2.substring(stl2,stl2+len)))
		{
		    return true ;
		}
		if(dp[stl1][stl2][len] != null)
		{
		    return dp[stl1][stl2][len] ;
		}
		
		for(int k = 1 ; k < len ; k++)
		{
		    if((isScrambleTab(s1,s2,stl1,stl2,k,dp) && isScrambleTab(s1,s2,stl1+k,stl2+k,len-k,dp) ) || (isScrambleTab(s1,s2,stl1+k,stl2,len-k,dp)  && isScrambleTab(s1,s2,stl1,stl2 + len-k,k,dp)))
		    {
		        dp[stl1][stl2][len] = true ;
		        return true ;
		    }
		}
		
		dp[stl1][stl2][len] = false ;
		return false;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int n = s1.length();
		System.out.println(isScrambleTab(s1,s2,0,0,n,new Boolean[n][n][n+1]));
	}

}
