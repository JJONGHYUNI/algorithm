import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        boolean flag = false;

        for (int i = 0; i < s.length() / 2; i++) {

            // 펠린드롬이 아니면 전체 길이
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                System.out.print(s.length());
                return;
            }

            // 하나라도 다른 문자가 있으면 같은 문자로만 이루어진게 아니기 때문에 flag = true
            if (s.charAt(i) != s.charAt(i + 1)) {
                flag = true;
            }

        }

        // 펠린드롬이고 여러 문자로 되어있으면 하나만 지워주면 됨 'ABBA -> 'ABB', 'BBA'
        if (flag) {
            System.out.print(s.length() - 1);
            return;
        }
        
        System.out.print(-1);
    }
}
