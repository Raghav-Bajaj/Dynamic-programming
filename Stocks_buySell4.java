import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int[] prices = new int[n];
     for(int i = 0 ; i < n ; i++)
        prices[i] = sc.nextInt();
    int bsp = -prices[0];
    int ssp = 0 ;
    int csp = 0 ;
       for(int i = 1 ; i < n ; i++)
       {
         int nbsp = 0 ;
        int ncsp = 0 ;
       int nssp = 0 ;

           if(csp - prices[i]  > bsp)
           {
               nbsp = csp - prices[i] ;
           }else{
               nbsp = bsp ;
           }
           if(bsp + prices[i] > ssp)
           {
               nssp = bsp + prices[i] ;
           }else{
               nssp = ssp ;
           }
           if(ssp > csp)
           {
               ncsp = ssp;
           }else{
               ncsp = csp ;
           }
           bsp = nbsp ;
           ssp = nssp ;
           csp = ncsp ;
       }
       System.out.println(ssp);
    }

}
