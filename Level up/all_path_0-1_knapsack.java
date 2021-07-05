import java.io.*;
import java.util.*;

public class Main {
    public static class Pair{
        int i ;
        int j ;
        String psf ;
        Pair(int i , int j , String psf)
        {
            this.i = i ;
            this.j = j ;
            this.psf = psf ;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

       int[][] dp = new int[n+1][cap+1];
       for(int i = 1 ; i < n+1 ; i++)
       {
           for(int  j = 1 ; j < cap +1 ; j++)
           {
              dp[i][j] = dp[i-1][j];
               if(j>= wts[i-1])
               {
                   dp[i][j] = Math.max(dp[i-1][j] , values[i-1] + dp[i-1][j-wts[i-1]]);
               }
           }
       }
       System.out.println(dp[n][cap]);
       ArrayDeque<Pair> q = new ArrayDeque<>();
       q.add(new Pair(n,cap,""));
       while(q.size() > 0 )
       {
           Pair p = q.remove();
           if(p.i == 0 || p.j == 0)
           {
               System.out.println(p.psf);
           }else{
               int ex = dp[p.i-1][p.j];
               if(ex == dp[p.i][p.j])
               {
                   q.add(new Pair(p.i,p.j-1,p.psf));
               }
               if(p.j >= wts[p.i-1])
               {
                   int inc = dp[p.i-1][p.j-wts[p.i-1]] + values[p.i-1] ;
                   if(dp[p.i][p.j] == inc)
                   {
                       q.add(new Pair(p.i-1 , p.j-wts[p.i-1], (p.i-1)+ " "+p.psf ));
                   }
               }
           }
       }
        
    }
}


                        


                        


                        
