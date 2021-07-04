import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

     int[][] dp = new int[n][m];
 for(int j = arr[0].length - 1; j >= 0; j--){
          for(int i = 0; i < arr.length; i++){
              if(j == arr[0].length - 1){
                  dp[i][j] = arr[i][j];
              } else if(i == 0){
                  dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
              } else if(i == arr.length - 1){
                  dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
              } else {
                  dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
              }
          }
      }
     
 
     
     
     
     int max = Integer.MIN_VALUE;
     int max_i = 0 ;
    //  int max_j = 0 ;
     for(int i = 0 ; i < n ; i++)
     {
         if(dp[i][0] > max)
         {
             max = dp[i][0] ;
             max_i = i ;
         }
     }
          System.out.println(max);
          ArrayDeque<Pair> q = new ArrayDeque<>();
          for(int i = 0 ; i < n ; i++)
     {
         if(dp[i][0] == max)
            q.add(new Pair(i + "" , i , 0));
     }
     while(q.size() > 0 )
     {
        Pair p = q.remove();
        if(p.j == m-1)
        {
            System.out.println(p.psf);
        }else if(p.i == 0)
        {
            if(dp[p.i][p.j+1] > dp[p.i+1][p.j+1])
            {
                  q.add(new Pair(p.psf + " d2" , p.i, p.j+1));
            }else  if(dp[p.i][p.j+1] <  dp[p.i+1][p.j+1]){
                 q.add(new Pair(p.psf+ " d1" , p.i+1, p.j+1));
            }else{
                 q.add(new Pair(p.psf + " d2" , p.i, p.j+1));
                  q.add(new Pair(p.psf + " d1" , p.i+1, p.j+1));
            }
        }else if(p.i == n-1)
        {
             if(dp[p.i][p.j+1] > dp[p.i-1][p.j+1])
            {
                  q.add(new Pair(p.psf + " d2" , p.i, p.j+1));
            }else  if(dp[p.i][p.j+1] < dp[p.i-1][p.j+1]){
                 q.add(new Pair(p.psf+ " d1" , p.i-1, p.j+1));
            }else{
                 q.add(new Pair(p.psf+ " d2" , p.i, p.j+1));
                  q.add(new Pair(p.psf + " d1" , p.i-1, p.j+1));
            }
            
        }else{
          int g = Math.max(dp[p.i][p.j+1] ,Math.max(dp[p.i+1][p.j+1] , dp[p.i-1][p.j+1]));
          if(g == dp[p.i][p.j+1])
          {
                q.add(new Pair(p.psf + " d2" , p.i, p.j+1));
          }
          if(g == dp[p.i+1][p.j+1])
          {
                q.add(new Pair(p.psf + " d3" , p.i+1, p.j+1));
          }
          if(g == dp[p.i-1][p.j+1])
          {
                q.add(new Pair(p.psf + " d1" , p.i-1, p.j+1));
          }
            
        }
     }
   }


}
