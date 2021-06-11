import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int[] arr = new int[n];
for(int i = 0  ; i < n ; i++)
{
    arr[i] = sc.nextInt();
}
int t = sc.nextInt();
int[] dp = new int[t+1];
dp[0] = 1 ;
for(int i = 0 ; i < n ; i ++)
{
    for(int j = arr[i] ; j <= t ; j++)
    {
        dp[j] += dp[j-arr[i]];
    }
}
System.out.print(dp[t]) ;
    }
}
