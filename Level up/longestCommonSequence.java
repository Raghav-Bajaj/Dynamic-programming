import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String st1 = sc.nextLine();
    String st2 = sc.nextLine();
    int[][] dp = new int[st1.length() + 1][st2.length() + 1];
    for(int i = dp.length - 2 ; i >= 0 ; i--)
    {
        for(int j = dp[0].length -2 ; j >= 0 ; j--)
        {
            if(st1.charAt(i) == st2.charAt(j))
            {
                dp[i][j] = 1 + dp[i+1][j+1];
            }else{
                dp[i][j] = Math.max(dp[i+1][j] , dp[i][j+1]);
            }
        }
    }
    System.out.println(dp[0][0]);
    }

}
