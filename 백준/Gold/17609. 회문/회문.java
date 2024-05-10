import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> checkList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String str;

        for (int i = 0; i < t; i++) {
            str = br.readLine();
            check(str.toCharArray());
        }
    }

    private static void check(char[] s) {
        int len = s.length;
        boolean control = false;
        for (int i = 0; i < len / 2; i++) {
            if (s[i] != s[len - i - 1] && !control) {
                control = true;
                String tmp = new String(s);
                String tmp1 = tmp.substring(0, i) + tmp.substring(i + 1);
                String tmp2 = tmp.substring(0, len - i - 1) + tmp.substring(len - i);
                isSimilar(tmp1.toCharArray(), tmp2.toCharArray());
            }
        }

        if (!control) {
            System.out.println(0);
        }
    }


    private static void isSimilar(char[] tmp, char[] tmp2) {
        int len = tmp.length;
        boolean control = false, control2 = false;
        for (int i = 0; i < len / 2; i++) {
            if (tmp[i] != tmp[len - i - 1] && !control) {
                control = true;
            }

            if (tmp2[i] != tmp2[len - i - 1] && !control2) {
                control2 = true;
            }
        }

        if (!control || !control2) {
            System.out.println(1);
            return;
        }
        System.out.println(2);
    }
}