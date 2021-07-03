import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    
    public static class Pair {
        int l;
        int i;
        int v;
        String psf;
        
        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
        
    public static void solution(int []arr){
        int[] dp = new int[arr.length];
        int omax = 0 ;
        int omaxi = 0 ;
        
        for(int i = 0 ; i < dp.length ; i++)
        {
            int max = 0 ;
            for(int j = 0 ; j < i ; j++)
            {
                if(arr[j] <= arr[i])
                {
                    if(dp[j] > max)
                    {
                        max = dp[j] ;
                    }
                }
                
            }
             dp[i] = max +1 ;
                if(dp[i]  > omax)
                {
                    omax = dp[i] ;
                    omaxi =  i ;
                }
        }
        System.out.println(omax);
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(omax , omaxi , arr[omaxi] , arr[omaxi] + ""));
        while(q.size() > 0 )
        {
            Pair p = q.remove();
            if(p.l == 1)
            {
                System.out.println(p.psf);
            }
            for(int i = p.i-1 ; i >= 0 ; i--)
            {
                if(dp[i] == p.l - 1 && arr[i] <= p.v)
                {
                    q.add(new Pair(dp[i]  , i , arr[i]  , arr[i] + " -> " + p.psf));
                }
            }
        }
    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
