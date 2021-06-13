import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int n  = sc.nextInt();
      int[] prices = new int[n];
      for(int i = 0 ; i < n ; i++)
        prices[i] = sc.nextInt();
        
        int least = prices[0];
        int sold = 0 ;
        int[] dpl = new int[n];
        for(int i = 1 ; i < n ; i++)
        {
            if(prices[i] < least)
            {
                least = prices[i] ;
            }
            sold  = prices[i] - least ;
            if(dpl[i-1] < sold)
            {
                dpl[i] = sold ;
            }else{
                dpl[i] = dpl[i-1];
            }
        }
        int max = prices[n-1];
        int buy = 0 ;
         int[] dpr = new int[n];
        for(int i = n-2 ; i >=0 ; i--)
        {
            if(prices[i] > max)
                max = prices[i] ;
            if(max-prices[i] > dpr[i+1])
            {
                dpr[i] = max -prices[i];
            }else{
                dpr[i] = dpr[i+1];
            }
        }
        int res = 0 ;
        for(int i = 0 ; i < n ; i++)
        {
            if(dpl[i] + dpr[i] > res)
                res = dpl[i] + dpr[i] ;
        }
        System.out.println(res);
    }

}
