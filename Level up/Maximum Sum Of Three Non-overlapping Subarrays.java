import java.io.*;
import java.util.*;

public class Main {

	public static void solution(int[] arr, int k){
	    int  n = arr.length ;
		int[] preSum = new int[n];
		preSum[0] = arr[0] ;
		for(int i =1 ; i < n ; i++)
		{
		    preSum[i]= preSum[i-1]+arr[i] ;
		}
		int[] left = new int[n];
		for(int i = 0 ; i < n ; i ++)
		{
		    if( i < k)
		    {
		        left[i] = preSum[i] ;
		    }else{
		        left[i] = Math.max(left[i-1],preSum[i] - preSum[i-k]);
		    }
		}
		int[] right = new int[n];
		int sum = 0 ;
		for(int i = n-1 ; i >=0 ; i--)
		{
		    if(i+k >= n)
		    {
		       sum +=arr[i];
		       right[i] = sum ;
		        
		    }else{
		        sum += arr[i] - arr[i+k];
		        right[i] = Math.max(right[i+1] , sum);
		    }
		}
		
		int maxSum = 0 ;
		int sl = -1 ;
		int sm = -1 ;
		int sr = -1 ;
		for(int i = k ; i <= n-2*k ; i++)
		{
		    if(left[i-1] + right[i+k] + preSum[i+k-1] - preSum[i-1] > maxSum )
		    {
		        maxSum = left[i-1] + right[i+k] + preSum[i+k-1] - preSum[i-1]  ;
		        sm = i ;
		        sl = left[i-1] ;
		        sr = right[i+k] ;
		    }
		}
		System.out.print(maxSum + " ");
		for(int i = k-1 ; i < sm   ; i++)
		{
		    if(preSum[i] - (i-k < 0 ? 0 : preSum[i-k]) == sl) 
		    {
		        System.out.print(i-k + 1 + " ");
		        break ;
		    }
		}
		System.out.print(sm  + " ");
		for(int i = sm + 2*k  - 1  ; i < n  ;  i++)
		{
		    if(preSum[i] - preSum[i-k] == sr)
		    {
		         System.out.print(i-k +1 + " ");
		        break ;
		    }
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
