import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[] chars;
    static int[] alphabets;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            chars = br.readLine().toCharArray();
            alphabets = new int[26];

            for (char c : chars) {
                alphabets[c - 'a']++;
            }

            dfs(0, "");
        }

        System.out.print(sb);
    }

    private static void dfs(int depth, String s) {
        if (depth == chars.length) {
            sb.append(s);
            sb.append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] > 0) {
                alphabets[i]--;
                dfs(depth + 1, s + (char)('a' + i));
                alphabets[i]++;
            }
        }
    }
}