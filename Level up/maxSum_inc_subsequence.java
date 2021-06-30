import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i  <n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        int total  = dp[0] ;
        for(int i = 1 ;i < n ; i++)
        {
            int sum = 0 ;
            for(int j = 0 ; j < i ; j++)
            {
                if(arr[j] < arr[i])
                {
                    if(dp[j] > sum)
                    {
                        sum = dp[j];
                    }
                }
              
            }
              dp[i] = sum + arr[i] ;
                if(dp[i] > total)
                {
                    total = dp[i];
                }
        }
        System.out.println(total);
    }

}
