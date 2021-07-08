import java.io.*;
import java.util.*;

public class Main {
public static long kadan(int[] arr)
{
    long sum = arr[0] ;
    long max = arr[0] ;
    for(int i = 1 ; i < arr.length ; i++ )
    {
        if(sum + arr[i] < arr[i])
        {
            sum = arr[i] ;
        }else{
            sum +=arr[i];
        }
        if(sum > max)
        {
            max = sum ;
        }
    }
    return max ;
}
public static long createArray(int[] arr)
{
    int[] res = new int[arr.length*2];
    int  p = 0 ;
    for(int i = 0 ; i < arr.length ; i++)
    {
        res[p] = arr[i] ;
        p++;
    }
     for(int i = 0 ; i < arr.length ; i++)
    {
        res[p] = arr[i] ;
        p++;
    }
    long sol = kadan(res);
    return sol ;
}
  public static long solution(int[] arr, int k, long sum) {
if(k == 1)
{
    long ans = kadan(arr);
    return ans ;
}else if(sum < 0 )
{
    long ans = createArray(arr);
    return ans ;
    
}else{
     long ans = createArray(arr);
    return ans + (k-2)*sum ;
}
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
      sum += arr[i];
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k, sum));
  }

}
