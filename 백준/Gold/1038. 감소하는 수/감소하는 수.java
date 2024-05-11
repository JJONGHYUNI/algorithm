import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int len = 1_000_000;
    static List<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr.add(0l);

        for (int i = 1 ; i < 10; i++) {
            findDiminish(Integer.toString(i), i, 0);
        }
        
        Collections.sort(arr);
        
        try {
            System.out.print(arr.get(n));
        } catch (IndexOutOfBoundsException e) {
            System.out.print(-1);
        }
    }

    private static void findDiminish(String n, int previous, int depth) {
        if (depth == 10) {
            return;
        }

        arr.add(Long.parseLong(n));

        for (int i = 0; i < previous; i++) {
            findDiminish(n + Integer.toString(i), i, depth + 1);
        }
    }
}