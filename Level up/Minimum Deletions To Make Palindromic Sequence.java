import java.util.Scanner;
public class Main{
    public static int minimumDeletionsToPalindrome(String s){
        int n = s.length();
       int[][] dp = new int[n][n];
       for(int g = 0 ; g < n ; g++)
       {
           for(int  i = 0  , j = g ; j < n ; j++ , i++)
           {
               if(g == 0)
               {
                   dp[i][j] = 1 ;
               }else if(g==1)
               {
                   if(s.charAt(i) == s.charAt(j))
                   {
                       dp[i][j] = 2 ;
                   }else {
                       dp[i][j] = 1 ;
                   }
               }else{
                   if(s.charAt(i) == s.charAt(j))
                   {
                       dp[i][j] = 2 + dp[i+1][j-1];
                   }else{
                       dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                   }
               }
           }
       }
        return s.length() - dp[0][n-1];
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        System.out.println(minimumDeletionsToPalindrome(str));
    }
}
