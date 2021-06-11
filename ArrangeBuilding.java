import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();
int build = 1 ;
int space = 1 ;
if(n == 0)
{
    System.out.println(0);
    return ;
}
int i = 2 ;
while(i <= n)
{
    int temp = space ;
    space = build+space ;
    build = temp ;
    i++;
}
long temp = build+space ;
System.out.println(temp*temp);
 }

}
