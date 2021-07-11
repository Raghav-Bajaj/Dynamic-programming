import java.io.*;
import java.util.*;

public class Main {

  public static boolean solution(String s1, String s2, String s3 , int i , int j , Boolean[][] dp) {
    if(i == s1.length() && j == s2.length())
    {
        dp[i][j] = true ;
        return true ;
    }
    if(dp[i][j] != null)
    {
        return dp[i][j] ;
    }
    if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j))
    {
        boolean f1 = solution(s1,s2,s3,i+1,j,dp);
        dp[i][j] = f1 ;
        if(f1)
        {
            return true ;
        }
    }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j))
    {
        boolean f2 = solution(s1,s2,s3,i,j+1,dp);
        dp[i][j] = f2 ;
        if(f2)
        {
            return true ;
        }
    }
    dp[i][j] = false ;
    return false ;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();
    if(s1.length() + s2.length() != s3.length() )
    {
        System.out.println(false);
        return ;
    }
    
    System.out.println(solution(s1, s2, s3 , 0 , 0 ,new Boolean[s1.length()+1][s2.length()+1] ));
  }

}
