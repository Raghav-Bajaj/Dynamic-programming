import java.io.*;
import java.util.*;

public class Main {

	public static boolean solution(String sentence, HashSet<String> dictionary) {
		int n = sentence.length();
		int[] dp = new int[n];
		for(int i = 0 ; i  < n ; i++)
		{
		    for(int j = 0 ; j <= i ; j++)
		    {
		        String s = sentence.substring(j,i+1);
		        if(dictionary.contains(s))
		        {
		            if(j > 0 )
		            {
		                dp[i] += dp[j-1] ;
		            }else{
		                dp[i] += 1 ;
		            }
		        }
		    }
		}

		return dp[n-1] > 0 ? true : false ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dictionary = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			dictionary.add(scn.next());
		}
		String sentence = scn.next();
		System.out.println(solution(sentence, dictionary));
	}

}
