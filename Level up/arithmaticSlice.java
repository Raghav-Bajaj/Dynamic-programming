import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		int ans = 0 ;
		for(int i= 1 ; i < n-1 ; i++)
	{
	    if(arr[i]-arr[i-1] == arr[i+1] - arr[i])
	    {
	        dp[i] = dp[i-1]+1;
	        ans += dp[i] ;
	        
	    }
	}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
