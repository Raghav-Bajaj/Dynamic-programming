import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int n) {
    int[] dp = new int[n+1];
    dp[1] = 1 ;
    int tw =1 ;
    int tr =1 ;
    int fv = 1 ;
    for(int i = 2 ; i <= n ; i++)
    {
    int p1 = dp[tw]*2  ;
    int p2 = dp[tr]*3 ;
    int p3 = dp[fv]*5 ;
        dp[i] = Math.min(p1,Math.min(p2,p3));
        if(dp[i] == p1)
        {
            tw++;
        }
        if(dp[i] == p2)
        {
            tr++;
        }
        if(dp[i] == p3)
        {
            fv++ ;
        }
        
        
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }

}
