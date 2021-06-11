import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n  = sc.nextInt();
       int m = sc.nextInt();
       int[][] arr = new int[n][m] ;
       for(int  i = 0 ; i < n  ; i++)
       {
           for(int j = 0 ; j < m ; j++)
           {
               arr[i][j] = sc.nextInt();
           }
       }
       int ans = MinCost(arr,n,m);
       System.out.println(ans);

        }
        public static int MinCost(int[][] mat , int n , int m)
        {
            int[][]dp = new int[n][m] ;
            for(int i = n-1 ; i >=0 ; i--)
            {
                for(int j= m-1 ; j>=0 ;j--)
                {
                    if(i == n-1 && j == m-1)
                    {
                     dp[i][j] = mat[i][j] ;   
                    }else if(i == n-1)
                    {
                        dp[i][j] = dp[i][j+1]+mat[i][j] ;
                    }else if(j == m-1)
                    {
                     dp[i][j] = dp[i+1][j] + mat[i][j];   
                    }else{
                        dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+mat[i][j];
                    }
                }
            }
            return dp[0][0];
        }
}
