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
       int[] lcs = new int[n];
       lcs[0] = 1 ;
       for(int i = 1 ; i < n ;i++)
       {
           int max = 0 ;
           for(int j = 0 ; j < i ; j++)
           {
               if(arr[j] < arr[i])
               {
                   if(lcs[j] > max)
                   {
                       max = lcs[j];
                   }
               }
           }
           lcs[i] = max + 1 ;
       }
       
       int[] mds = new int[n] ;
       mds[n-1] = 1 ;
       for(int i = n-2 ; i >=0 ; i--)
       {
           int max = 0 ;
           for(int j = i+1 ; j < n ; j++)
           {
               if(arr[i] > arr[j])
               {
                   max = mds[j];
               }
           }
           mds[i] = max+1;
       }
       int total = 0 ;
       for(int i = 0 ; i < n ; i++)
       {
        
           if(mds[i]+lcs[i] > total)
           {
               total = mds[i]+lcs[i] ;
           }
       }
       System.out.println(total -1 );
    }

}
