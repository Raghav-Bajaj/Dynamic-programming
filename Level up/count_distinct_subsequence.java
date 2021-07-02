import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        long[] dp = new long[s.length()+1];
        dp[0] = 1 ;
           HashMap<Character , Integer> set = new HashMap<>();
        for(int i = 1 ; i < dp.length ; i++)
        {
         dp[i] = dp[i-1]*2;
         char c = s.charAt(i-1);
         if(set.containsKey(c))
         {
             int j = set.get(c);
             dp[i] = dp[i] - dp[j-1] ;
         }
         set.put(c , i);
        }
     System.out.println(dp[s.length()]-1);
    }
}
