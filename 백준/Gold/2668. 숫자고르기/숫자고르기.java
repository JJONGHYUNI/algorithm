import java.util.*;
import java.io.*;


public class Main {
    static List<Integer> answer;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
        answer = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int ans : answer) {
            System.out.println(ans);
        }

    }

    private static void dfs(int start, int target) {
        if(arr[start] == target) {
            answer.add(target);
        }
        if(!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }
    }
}