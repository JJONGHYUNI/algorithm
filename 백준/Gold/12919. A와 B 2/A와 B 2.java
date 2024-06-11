import java.io.*;
import java.util.*;

class Main {

    static String s;
    static boolean answer = false;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            s = br.readLine();
            String t = br.readLine();
            answer = false;
            dfs(t);
            if (answer) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }

        }

    private static void dfs(String tmp) {
        if (tmp.length() == s.length()) {
            if (tmp.equals(s)) {
                answer = true;
            }
            return;
        }

        if (tmp.charAt(0) == 'B') {
            sb = new StringBuilder(tmp.substring(1));
            dfs(sb.reverse().toString());
        }
        if (tmp.charAt(tmp.length() - 1) == 'A') {
            dfs(tmp.substring(0, tmp.length() - 1));
        }
    }
}