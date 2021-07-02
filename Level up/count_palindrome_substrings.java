        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0 ;
        for(int g = 0 ; g < s.length() ; g++ )
        {
            for(int  i = 0 , j = i+g ; j < s.length() ; i++ , j++ )
            {
                if(g == 0)
                {
                    dp[i][j] = true;
                    count++;
                }else if(g == 1)
                {
                    if(s.charAt(i) == s.charAt(j))
                    {
                        dp[i][j] = true ;
                        count++ ;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j))
                    {
                        if(dp[i+1][j-1] == true)
                        {
                            dp[i][j] = true;
                            count++;
                        }
                    }
                }
            }
        }
