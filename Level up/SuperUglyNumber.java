import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] primes, int n) {
   int[] dp = new int[n+1];
   dp[1] = 1 ;
   int[] facts = new int[primes.length];
   Arrays.fill(facts , 1);
   int  p = 2 ;
   while(p  <=   n)
   {
      int min = Integer.MAX_VALUE ;
      for(int i = 0 ; i < facts.length ; i++)
      {
          int temp = dp[facts[i]]*primes[i] ;
          if(temp < min)
          {
              min = temp ;
          }
      }
       dp[p] = min ;
    //   System.out.println(dp[p]);
       for(int i = 0 ; i < facts.length ; i++)
          {
              if(dp[p] == dp[facts[i]]*primes[i] )
              {
                  facts[i] = facts[i] + 1 ;
              }
          }
          p++;
   }
//   for(int val : dp)
//   {
//       System.out.print(val + " ");
//   }
    return dp[n] ;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int k = scn.nextInt();
    int[] primes = new int[k];
    for (int i = 0 ; i < k; i++) {
      primes[i] = scn.nextInt();
    }
    int n = scn.nextInt();
    System.out.println(solution(primes, n));
  }

}
