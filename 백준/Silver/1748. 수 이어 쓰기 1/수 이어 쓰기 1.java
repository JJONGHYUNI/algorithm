import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tmp=10;
        int cnt=0;
        int ans=0;
        while (true){
            if (n/tmp==0){
                cnt++;
                tmp/=10;
                break;
            }
            cnt++;
            tmp*=10;
        }
        int a= n/tmp;
        int b= n%tmp;
        ans=cnt*(a-1)*tmp;
        ans=ans+(b+1)*cnt;
        int idx=9;
        cnt=1;
        while (true){
            if (tmp<idx){
                break;
            }
            ans+=idx*cnt++;
            idx*=10;
        }
        System.out.println(ans);
    }
}