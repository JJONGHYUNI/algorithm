import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] ss = s.toCharArray();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int cnt;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            cnt = 0;
            for (int j = l; j <= r; j++) {
                if (a == ss[j]) {
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        }
    }
}