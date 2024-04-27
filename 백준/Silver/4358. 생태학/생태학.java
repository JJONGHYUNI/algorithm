import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        String s;

        while (true) {
            s = br.readLine();
            if (s == null || s.length() == 0) break;
            cnt += 1;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> trees = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            trees.add(entry.getKey());
        }

        Collections.sort(trees);

        for (String tree : trees) {
            double tmp = map.get(tree) * 100.0 / cnt;
            sb.append(tree).append(" ").append(String.format("%.4f", tmp)).append("\n");
        }

        System.out.print(sb);
    }
}