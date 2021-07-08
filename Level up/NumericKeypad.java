import java.io.*;
import java.util.*;

public class Main {
    public static int ValidAdd(int i , int j , int[][] curr)
    {
       if(i == 3)
       {
           if(j == 0 || j == 2)
           {
               return  0 ;
           }
       }
       
       int res = curr[i][j] ;
       if(i-1 >=0)
       {
           res += curr[i-1][j];
       }
       if(i+1 < 4)
       {
           res += curr[i+1][j];
       }
       if(j-1 >=0)
       {
           res += curr[i][j-1];
       }
       if(j+1 < 3)
       {
           res +=curr[i][j+1];
       }
       return res ;
        
    }
	public static int solution(int n) {
		int[][] curr = new int[4][3];
	    int[][] next = new int[4][3];
	   for(int i = 0 ; i < curr.length ; i++)
    {
        for(int j = 0 ; j <  curr[0].length ; j++)
        {
            if( i == 3)
            {
                if(j == 0 || j == 2)
                {
                    curr[i][j] = 0 ;
                }else{
                    curr[i][j] = 1 ;
                }
            }else{
                curr[i][j] = 1 ;
            }
        }
    }
    int t = 1 ;
        while(t < n)
        {
        for(int i = 0 ; i < curr.length ; i++)
    {
        for(int j = 0 ; j <  curr[0].length ; j++)
        {
            next[i][j] = ValidAdd(i,j,curr);
        }
    }
    curr = next ;
    next = new int[4][3] ;
            
            t++;
        }
 
    int sum = 0 ;
    for(int i = 0 ; i < curr.length ; i++)
    {
        for(int j = 0 ; j <  curr[0].length ; j++)
        {
            sum += curr[i][j];
        }
    }
		return sum;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println(solution(scn.nextInt()));
	}

}
