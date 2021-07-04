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
      for(int  i = n-1 ; i >=0  ; i--)
      {
          for(int  j = m -1 ; j>=0;j--)
          {
              if(i == n-1 && j == m-1)
              {
                  dp[i][j] = arr[i][j];
              }else if(j == m-1)
              {
                  dp[i][j] = dp[i+1][j] + arr[i][j] ;
              }else if(i == n-1)
              {
                  dp[i][j] = dp[i][j+1] + arr[i][j];
              }else{
                  dp[i][j] = arr[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
              }
          }
      }
      System.out.println(dp[0][0]);
      ArrayDeque<Pair> q = new ArrayDeque<>();
      q.add(new Pair("" , 0 , 0 )) ;
      while(q.size() > 0 )
      {
          Pair p = q.remove();
          
          if(p.i == n -1 && p.j == m-1)
          {
              System.out.println(p.psf);
          }else if(p.i == n-1)
          {
              q.add(new Pair(p.psf+ "H" ,p.i ,p.j+1 ));
          }else if(p.j == m-1){
               q.add(new Pair(p.psf+ "V" ,p.i+1 ,p.j ));
             }else{
                  if(dp[p.i][p.j+1] < dp[p.i+1][p.j])
          {
              q.add(new Pair(p.psf+ "H" ,p.i ,p.j+1 ));
          }else if(dp[p.i][p.j+1] > dp[p.i+1][p.j]){
               q.add(new Pair(p.psf+ "V" ,p.i+1 ,p.j ));
             }else{
                 q.add(new Pair(p.psf+ "V" ,p.i+1 ,p.j ));
                q.add(new Pair(p.psf+ "H" ,p.i ,p.j+1 ));
                 
             }
             }
      }
      
   }

}
