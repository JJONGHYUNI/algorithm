import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    static int[] arr;
    static int n;
    static int m;
    static boolean[] visited;
    static Stack<Integer> answer = new Stack<>();
    static LinkedHashSet<String> ans = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n];
        Arrays.sort(arr);
        dfs(0);
        ans.forEach(System.out::println);
    }

    private static void dfs(int num) {
        if (num == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(answer.get(i) + " ");
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            if (!visited[i]) {
                answer.add(tmp);
                visited[i] = true;
                dfs(num + 1);
                answer.pop();
                visited[i] = false;
            }
        }
    }
}