import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] alphabets;
    static char[] s;
    static boolean[] visited;
    static int k, min, max;
    static List<Integer> idxs;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            s = br.readLine().toCharArray();
            alphabets = new int[26];
            visited = new boolean[26];
            k = Integer.parseInt(br.readLine());
            findAlphabets();
            min = Integer.MAX_VALUE;
            max = -1;
            for (int j = 0; j < s.length; j++) {
                idxs = new ArrayList<>();
                game(j);
            }
            if (max == -1) {
                sb.append(max).append("\n");
                continue;
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    private static void findAlphabets() {
        for (int i = 0; i < s.length; i++) {
            alphabets[s[i] - 'a']++;
        }
    }

    private static void game(int idx) {
        char tmp = s[idx];

        if (alphabets[tmp - 'a'] < k || visited[tmp - 'a']) {
            return;
        }

        idxs.add(idx);
        visited[tmp - 'a'] = true;

        for (int i = idx + 1; i < s.length; i++) {
            if (s[i] == tmp) {
                idxs.add(i);
            }
        }

        findMinMax();
    }

    private static void findMinMax() {
        for (int i = 0; i <= idxs.size() - k; i++) {
            int len = idxs.get(i + k - 1) - idxs.get(i) + 1;
            max = Math.max(len, max);
            min = Math.min(len, min);
        }
    }
}