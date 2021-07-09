import java.io.*;
import java.util.*;

public class Main {

	public static void optimalStrategy(int[] arr) {
		int n = arr.length ;
		int[][] dp = new int[n][n];
		for(int g = 0 ; g < n ; g++ )
		{
		    for(int  i = 0  , j = g ; j < n ; i++ , j++)
		    {
		        if(g == 0)
		        {
		            dp[i][j] = arr[i] ;
		            
		        }else if(g == 1)
		        {
		         dp[i][j] = Math.max(arr[i] , arr[j]);   
		        }else{
		            int val1 = arr[i] + Math.min(dp[i+2][j] , dp[i+1][j-1]);
		            int val2 = arr[j] + Math.min(dp[i+1][j-1] , dp[i][j-2]);
		            dp[i][j] = Math.max(val1 , val2);
		        }
		    }
		}
	        System.out.println(dp[0][n-1]);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scn.nextInt();
		}
		optimalStrategy(a);
	}

}
