import java.io.*;
import java.util.*;

public class Main {

  public static boolean solution(int[] stones) {
    HashMap<Integer ,HashSet<Integer>> map = new HashMap<>();
    for(int i = 0 ; i < stones.length ; i++)
    {
        map.put(stones[i] , new HashSet<>());
    }
    map.get(stones[0]).add(1);
    for(int i = 0 ; i < stones.length ; i++)
    {
        int curr = stones[i] ;
        HashSet<Integer> jumps = map.get(curr);
        for(int jump : jumps)
        {
            if(map.containsKey(jump+curr))
            {
                if(jump+curr  == stones[stones.length - 1])
                {
                    return true ;
                }
                if(jump - 1 > 0)
                {
                    map.get(jump+curr).add(jump -1);
                    
                }
                map.get(jump+curr).add(jump);
                map.get(jump+curr).add(jump+1);
            }
        }
    }
        return false ;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(solution(arr));
  }

}
