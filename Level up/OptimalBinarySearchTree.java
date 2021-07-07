import java.io.*;
import java.util.*;

public class Main {
  
  private static void optimalbst(int[] keys, int[] frequency, int n) {
   int[][] dp = new int[keys.length][keys.length];
   int[] presum = new int[frequency.length];
   presum[0] = frequency[0];
   for(int i =  1 ; i < n ; i ++)
   {
       presum[i] =(presum[i-1]+frequency[i]);
   }
   for(int g = 0 ;  g < n ; g++)
   {
       for(int i = 0 , j = g ; j < n ;  i++ , j++ )
       {
           if(g==0)
           {
               dp[i][j] = frequency[i];
           }else if(g==1){
               dp[i][j] = dp[i][j-1] + dp[i+1][j];
               dp[i][j] += Math.min(dp[i][j-1] , dp[i+1][j]) ;
           }else{
               int sum = presum[j] - ((i==0)?0:presum[i-1]);
               int min = Integer.MAX_VALUE ;
               for(int k = i ; k <= j ; k++)
               {
                   int ls = (k==i)?0:dp[i][k-1];
                   int rs = (k==j)?0:dp[k+1][j];
                   if(ls+rs+sum < min)
                   {
                       min = ls + rs + sum ;
                   }
               }
               dp[i][j] = min ;
           }
       }
   }
   System.out.println(dp[0][n-1]);
    
	}

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
	int[] keys = new int[n];
	int[] frequency = new int[n];
    for(int i= 0 ;i < n ; i++) {
		keys[i] = scn.nextInt();
	}
	for(int i = 0 ; i < n; i++){
      frequency[i] = scn.nextInt();
    }
	optimalbst(keys,frequency,n);
	}

}
