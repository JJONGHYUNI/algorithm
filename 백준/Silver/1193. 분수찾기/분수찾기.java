import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int tmp=0,n=0;
        while(x>tmp){
            n++;
            tmp=n*(n+1)/2;
        }
        x=x-(n-1)*n/2;
        int bottom=n+1;
        int top=0;
        if (n%2==0){
            System.out.println((top+x)+"/"+(bottom-x));
        }
        else{
            System.out.println((bottom-x)+"/"+(top+x));
        }
    }
}