import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] price = new int[n];
            for(int i = 0 ; i < n ; i++)
                price[i] = sc.nextInt();
            int fee = sc.nextInt();
            int bsp = -price[0] ;
            int ssp = 0 ;
            for(int i = 1 ; i < n ; i++)
            {
                int nbsp = 0 ;
                int nssp = 0;
                if(ssp - price[i] > bsp )
                {
                    nbsp = ssp - price[i];
                }else{
                    nbsp = bsp ;
                }
                if(bsp + price[i] - fee > ssp){
                    nssp = bsp + price[i] - fee ;
                }else{
                    nssp = ssp ;
                }
                bsp = nbsp ;
                ssp = nssp ;
            }
        System.out.println(ssp);
    }

}
