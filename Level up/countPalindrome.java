import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
      int[][] dp  = new int[s.length()][s.length()];
      int count = 0 ;
      for(int g = 0 ; g < s.length() ; g++)
      {
          for(int j = g ,i = 0 ; j < s.length() ;i++, j++)
          {
              if(g == 0)
              {
                  dp[i][j] = 1 ;
              }else if(g == 1){
                   if(s.charAt(i) == s.charAt(j)){
                       dp[i][j] = 3 ;
                        
                    
                   }else{
                       dp[i][j] = 2 ;
                   }
                  }else{
                  if(s.charAt(i) == s.charAt(j))
                  {
                      dp[i][j] =dp[i+1][j] + dp[i][j-1] + 1;
                      
                  }else{
                      dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] ;
                  }
          
              }
          }
      }
      System.out.println(dp[0][dp.length-1] );
    }

}
