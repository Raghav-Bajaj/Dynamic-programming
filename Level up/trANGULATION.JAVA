import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n){
		int m = n-2 ;
		int[] dp = new int[m+1];
		dp[0]= 1;
		dp[1] = 1 ;
		for(int i = 2; i <= m ; i++ )
		{
		    for(int j = 0 ; j < i ; j++)
		    {
		        dp[i] += dp[j] * dp[i-j-1];
		    }
		}
		
		return dp[m];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}
