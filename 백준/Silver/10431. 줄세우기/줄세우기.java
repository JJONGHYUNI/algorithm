import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int [] arr = new int[20];
        for (int i = 0; i <t;i++){
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[0]=Integer.parseInt(st.nextToken());
            for(int j =0; j<20;j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0; j<20;j++){
                for(int k =0; k<j; k++) {
                    if(arr[k]>arr[j]){
                        cnt++;
                    }
                }
            }
            System.out.println((i+1) + " " + cnt);
        }
    }
}