import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2, int c1, int c2) {
		int n1 = s1.length() ;
		int n2 = s2.length() ;
		int[][] dp = new int[n1+1][n2+1];
		for(int i = n1-1 ; i >= 0 ; i--)
		{
		    for(int j = n2-1; j >=0 ; j--)
		    {
		        char p1 = s1.charAt(i);
		        char p2 = s2.charAt(j);
		        if(p1 == p2)
		        {
		            dp[i][j] = 1 + dp[i+1][j+1];
		        }else{
		            dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j]);
		        }
		    }
		}
		int sol = dp[0][0];
		int res = (n1-sol)*c1 + (n2-sol)*c2 ;
		return res ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(s1, s2,x, y));
	}

}
