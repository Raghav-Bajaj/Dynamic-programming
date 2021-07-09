import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		
		HashMap<Integer,Integer>[] map =  new HashMap[arr.length] ;
		int ans = 0 ;
		for(int i = 0 ; i <  arr.length ; i++)
		{
		    map[i] = new HashMap<>();
		}
		for(int i = 1 ; i  < map.length ; i++)
		{
		    for(int j = 0 ; j < i ; j++)
		    {
		        long p = (long)arr[i] - (long)arr[j] ;
		        if(p <= Integer.MIN_VALUE || p >= Integer.MAX_VALUE)
		        {
		           continue ;
		        }
		        int ict = map[i].getOrDefault((int)p , 0);
		        int jct = map[j].getOrDefault((int)p,0);
		        ans += jct ;
		        map[i].put((int)p,ict+jct+1);
		    }
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
