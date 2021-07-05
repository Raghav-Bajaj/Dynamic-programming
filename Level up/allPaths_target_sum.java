import java.io.*;
import java.util.*;

public class Main {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

       boolean[][] dp = new boolean[n+1][tar+1];
       for(int i = 0 ;i <= n ; i++)
       {
           for(int j = 0 ; j <= tar ; j++) 
           {
               if(j == 0)
               {
                   dp[i][j] = true ;
               }else if(i == 0)
               {
                   dp[i][j] = false ;
               }else{
                   if(dp[i-1][j] == true)
                   {
                       dp[i][j] = true ;
                   }else{
                       if(j >= arr[i-1])
                       {
                           if(dp[i-1][j-arr[i-1]] == true)
                           {
                               dp[i][j] = true ;
                           }
                       }
                   }
               }
           }
       }
       System.out.println(dp[n][tar]);
       ArrayDeque<Pair> q = new ArrayDeque<>();
       q.add(new Pair(n,tar , ""));
       while(q.size() > 0 )
       {
           Pair rp = q.remove();
            if(rp.j == 0 || rp.i == 0 )
           {
               System.out.println(rp.psf);
             
           }else {
				boolean exc = dp[rp.i - 1][rp.j];
				boolean inc = rp.j - arr[rp.i - 1] >= 0 ? dp[rp.i - 1][rp.j - arr[rp.i - 1]] : false;
				
				if (inc == true) {
					q.add(new Pair(rp.i - 1, rp.j - arr[rp.i - 1], (rp.i - 1) + " " + rp.psf));
				}
				if (exc == true) {
					q.add(new Pair(rp.i - 1, rp.j, rp.psf));
				}
			}
           
          
       }

    }
}
