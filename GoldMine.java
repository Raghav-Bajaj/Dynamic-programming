import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int[][] arr = new int[n][m];
       int[][] dp = new int[n][m];
       for(int i = 0 ; i < n ; i ++)
       {
           for(int j = 0 ; j < m ; j ++)
           {
               arr[i][j] = sc.nextInt();
               if(j == m-1)
               {
                dp[i][j] = arr[i][j] ;   
               }
           }
       }
       for(int j = m-2 ; j >= 0 ; j--)
       {
           for(int  i  = n-1 ; i >=0 ;i--)
           {
               if(i == 0)
               {
                   dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1])+arr[i][j];
               }else if(i == n-1)
               {
                    dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j+1])+arr[i][j];
               }else{
                    dp[i][j] = Math.max(dp[i][j+1],Math.max(dp[i-1][j+1],dp[i+1][j+1]))+arr[i][j];
               }
           }
       }
       
       int sol = Integer.MIN_VALUE ; 
       for(int i = 0 ; i < n ; i++)
       {
           if(dp[i][0] > sol)
            sol = dp[i][0];
    
       }
       System.out.println(sol);
    }

}
