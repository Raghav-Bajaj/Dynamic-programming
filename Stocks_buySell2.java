import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int[] arr = new int[n];
     for(int i = 0 ; i < n ; i++)
     {
         arr[i] = sc.nextInt();
     }
     int res = maxProfit(arr);
     System.out.println(res);
    }
    public static int maxProfit(int[] stocks)
    {
       int profit = 0 ;
       for(int i = 1 ; i < stocks.length ; i++)
       {
           if(stocks[i] > stocks[i-1])
           {
               profit += stocks[i]-stocks[i-1];
           }
       }
       return profit ;
    }
}
