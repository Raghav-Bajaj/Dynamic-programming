class Solution {
    public int countSquares(int[][] arr) {
        		int[][]  dp = new int[arr.length][arr[0].length];
		int ans = 0 ;
		for(int i = dp.length -1 ; i >= 0 ; i--)
		{
		    for(int j = dp[0].length -1 ; j >=0 ; j--)
		    {
		        if(arr[i][j] == 0)
		        {
		            dp[i][j] = 0 ;
		        }else if(i == dp.length-1 || j == dp[0].length -1)
		        {
		            dp[i][j] = 1 ;
		        }else{
		            dp[i][j] = Math.min(dp[i+1][j+1] , Math.min(dp[i+1][j],dp[i][j+1])) + 1;
		        }
                if(dp[i][j] != 0)
                {
                    ans+= dp[i][j] ;
                }
		    }
		}
        return ans ;
    }
}
