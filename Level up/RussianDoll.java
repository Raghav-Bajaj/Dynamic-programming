import java.io.*;
import java.util.*;

public class Main {

 public static class Pair implements Comparable<Pair>{
        int n ;
        int s ;
        Pair(int n , int s)
        {
            this.n = n ;
            this.s = s ;
        }
        public int compareTo(Pair o)
        {
            if(o.n == this.n)
            {
                return this.s - o.s ;
            }else{
                return this.n - o.n ;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Pair[] pair = new Pair[n];
        for(int i = 0 ; i < n ; i++)
        {
            String st = sc.nextLine();
            String[] ss = st.split(" ");
            int pp = Integer.parseInt(ss[0]);
            int gg = Integer.parseInt(ss[1]);
            pair[i] = new Pair(pp,gg);
        }
        Arrays.sort(pair);
        int[] dp = new int[n];
    int    maxi = 0 ;
    
    for(int i = 0; i < n ; i++)
    {
        int mm = 0 ;
        for(
            int j = 0;  j < i ; j++)
            {
                if(pair[j].s < pair[i].s && pair[j].n < pair[i].n)
                {
                    if(dp[j] > mm)
                    {
                        mm = dp[j] ;
                    }
                }
            }
            dp[i] = mm +1 ;
            if(dp[i] > maxi)
            {
                maxi = dp[i];
            }
    }
    System.out.println(maxi);
    }
}
