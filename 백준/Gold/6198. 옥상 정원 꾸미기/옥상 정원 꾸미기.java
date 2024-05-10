import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> buildings = new Stack<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());

            while (!buildings.isEmpty()) {
                if (buildings.peek() <= height) {
                    buildings.pop();
                    continue;
                }
                break;
            }
            ans += buildings.size();
            buildings.add(height);
        }
        System.out.print(ans);
    }
}