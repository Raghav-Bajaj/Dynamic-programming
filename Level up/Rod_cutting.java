import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] prices) {
   int[] nprice = new int[prices.length+1];
   int p  = 1 ;
   for(int i : prices )
   {
       nprice[p] = i ;
       p++;
   }
    int[] dp = new int[nprice.length];
    dp[0] =  0 ;
    dp[1] = nprice[1];
    for(int i = 2 ; i < dp.length ; i++)
    {
        dp[i] = nprice[i];
        int l = 1 ;
        int r = i-1;
        while(l <= r)
        {
            if(dp[l]+dp[r] > dp[i])
            {
                dp[i] = dp[l]+dp[r];
             
            }
               l++;
                r--;
        }
        
        
    }
    return dp[dp.length-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = scn.nextInt();
    }
    System.out.println(solution(prices));
  }

}
