import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static class Pair{
        int i ; 
        int s ;
        int j ;
        String ans ;
        Pair(int i , int s , int j , String ans)
        {
            this.i = i ;
            this.j = j ;
            this.s = s ;
            this.ans = ans ;
        }
    }
    public static void Solution(int arr[]){
        
        int n= arr.length;
        Integer[] dp = new Integer[n];
        dp[n-1] = 0 ;
        for(int i = n -2 ; i >=0 ; i--)
        {
            int min = Integer.MAX_VALUE ;
            int steps = arr[i] ;
            for(int j = 1 ; j <= steps && i+j < n ; j++)
            {
              
                 if(dp[j+i] != null && dp[j+i] < min )
                {
                    min = dp[j+i] ;
                }
            
                
            }
            if(min != Integer.MAX_VALUE )
            {
                dp[i] = min + 1;
            }
        }
        System.out.println(dp[0]);
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0 , arr[0] , dp[0] , 0 + ""));
        while(q.size() > 0 )
        {
            Pair p = q.removeFirst();
            if(p.j == 0)
            {
                System.out.println(p.ans + " .");
            }
            for(int j =1 ; j <= p.s && j + p.i < n ; j++)
            {
                
                if(dp[p.i+j] != null && dp[p.i + j] == p.j - 1)
                {
                    q.add(new Pair(p.i+j , arr[p.i+j] , dp[p.i+j] , p.ans + " -> " + (p.i+j)));
                }
               
            }
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
