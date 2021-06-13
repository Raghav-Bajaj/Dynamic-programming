import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] prices = new int[n];
       for(int i = 0 ; i < n ; i++)
       {
           prices[i] = sc.nextInt();
       }
       int k = sc.nextInt();
       
       int[][]dp  = new int[k+1][n];
       
       for(int i = 1 ; i<=k ; i++)
       {
           int max = Integer.MIN_VALUE ;
           for(int j = 1 ; j < n ; j++)
           {
               if(max < dp[i-1][j-1]-prices[j-1])
               {
                   max = dp[i-1][j-1]-prices[j-1] ;
               }
               if(max + prices[j] > dp[i][j-1])
               {
                   dp[i][j] = max + prices[j] ;
               }else{
                   dp[i][j] = dp[i][j-1];
               }
           }
       }
       System.out.println(dp[k][n-1]);
    }

}
