import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s, String t,int s1,int t1 ) {
		if(s1 == s.length())
		{
		    if(t1 == t.length())
		    {
		        return 1 ;
		    }
		    return  0 ;
		}
		if(t1 == t.length())
		{
		    return 1 ;
		}
		char a = s.charAt(s1);
		char b = t.charAt(t1);
		int tw = 0 ;
		if(a != b)
		{
		    tw = solution(s,t,s1+1,t1);
		}else{
		    int tw1 = solution(s,t,s1+1,t1);
		    int tw2 = solution(s,t,s1+1,t1+1);
		    tw = tw1 + tw2 ;
		}

		return tw;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2,0,0));
	}

}
