import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr, int k) {
   int sum = arr[0] ;
   int[] sum_array = new int[arr.length];
   sum_array[0] = arr[0];
   for(int  i = 1 ; i < arr.length ; i++)
   {
       if(sum + arr[i] < arr[i])
       {
           sum = arr[i];
       }else{
           sum += arr[i] ;
       }
       sum_array[i] = sum ;
   }
    int  i = 0 ;
     sum = 0 ;
    while(i < k)
    {
        sum += arr[i];
        i++;
    }
    
    int res = Integer.MIN_VALUE ;
     if(res < sum)
       {
           res = sum ;
       }
   for(i = k ; i < arr.length ; i++)
   {
       sum +=  arr[i] - arr[i-k];
       if(res < sum)
       {
           res = sum ;
       }
       int more = sum_array[i-k] + sum ;
       if(more >  res)
       {
           res = more ;
       }
   }
   return res ;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k));
  }
}
