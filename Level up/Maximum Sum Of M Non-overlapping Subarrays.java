import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr,int i , int m, int k , int[]  preSum, int[][] dp){
	    if(i >= arr.length || m == 0)
	    {
	        return 0 ;
	    }
	    if(dp[i][m] != 0)
	    {
	        return dp[i][m];
	    }
		int inc = preSum[i]  + solution(arr,i+k,m-1,k,preSum,dp);
		int exc = solution(arr,i+1,m,k,preSum,dp);
		int ans = Math.max(inc , exc);
		dp[i][m] = ans ;
		return ans ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
        int m = scn.nextInt();
        int k = scn.nextInt();
        int sum = 0 ; 
        for(int i = 0 ;  i < k ; i++)
        {
            sum += arr[i];
        }
        
      
        int[] preSum = new int[n];
        preSum[0] = sum ;
    for(int i = k , j = 0 ; i < n ; i++,j++)
    {
        sum +=arr[i] - arr[j] ;
        preSum[i-k+1] = sum ;
    }
    int[][] dp = new int[arr.length][m+1];
        System.out.println(solution(arr,0, m , k , preSum,dp));
	}

}
