import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int parent;
        List<Integer> children;

        Node(int parent) {
            this.parent = parent;
            children = new ArrayList<>();
        }
    }


    static List<Node> nodes = new ArrayList<>();
    static int cnt = 0;
    static int delete = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rootIdx = 0;
        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(-1));
        }

        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                rootIdx = i;
                nodes.add(new Node(parent));
                continue;
            }
            nodes.get(i).parent = parent;
            nodes.get(parent).children.add(i);
        }

        delete = Integer.parseInt(br.readLine());

        if (delete == rootIdx) {
            System.out.print(0);
            return;
        }

        dfs(rootIdx);

        System.out.print(cnt);
    }

    private static void dfs(int cur) {
        boolean isLeaf = true;

        for (int tmp : nodes.get(cur).children) {
            if (tmp == delete) {
                continue;
            }
            isLeaf = false;
            dfs(tmp);
        }

        if (isLeaf) {
            cnt += 1;
        }
    }
}
