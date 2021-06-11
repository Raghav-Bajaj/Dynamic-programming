	import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
 Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for(int i = 0 ; i < n ; i++){
            values[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; i++){
            weights[i] = sc.nextInt();
        }
        int cap = sc.nextInt();
        int[] dp = new int[cap+1];
        dp[0] = 0 ;
        for(int i = 1 ; i <= cap ; i++)
        {
            int max = 0 ;
            for(int j = 0 ; j < n ; j++)
            {
                if(weights[j] <= i)
                {
                    int remain = i - weights[j] ;
                    int val = dp[remain];
                    int total = val + values[j];
                    if(total > max)
                    {
                        max = total ;
                    }
                }
            }
            dp[i] = max ;
        }
        System.out.println(dp[cap]);
   
	    }
	}
