import java.io.*;
import java.util.*;

class Main {
    static String[] operators = new String[]{"+", "-", " "};
    static int n;
    static List<String> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            dfs(1, "1");
            Collections.sort(answer);
            for (String s : answer) {
                sb.append(s).append("\n");
            }
            sb.append("\n");
            answer.clear();
        }
        System.out.print(sb);
    }

    private static void dfs(int depth, String s) {
        if (depth == n) {
            String ss = s.replaceAll(" ","");
            if (calculate(ss)) {
                answer.add(s);
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            dfs(depth + 1, s + operators[i] + (depth + 1));
        }
    }

    private static boolean calculate(String s) {
        String[] strings = s.split("[+,-]");
        int tmp = Integer.parseInt(strings[0]);
        int idx = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                tmp += Integer.parseInt(strings[idx]);
                idx += 1;
            } else if (s.charAt(i) == '-') {
                tmp -= Integer.parseInt(strings[idx]);
                idx += 1;
            }
        }
        if (tmp == 0) {
            return true;
        }
        return false;
    }
}