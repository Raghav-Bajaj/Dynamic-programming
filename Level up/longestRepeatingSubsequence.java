import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s){
    int n = s.length();
    int[][] dp = new int[n+1][n+1];
    for(int i = n-1 ; i >=0 ; i--)
    {
        for(int j= n-1 ; j >=0 ; j-- )
        {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
             dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j]) ;
            if(c1 == c2 && i != j)
            {
                dp[i][j] = 1 + dp[i+1][j+1] ;
            }
            
        }
    }
    return dp[0][0] ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
