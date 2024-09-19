import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp > 0) {
                arr.add(tmp);
                continue;
            }
            arr2.add(tmp);
        }

        arr.sort(Integer::compareTo);
        arr2.sort(Integer::compareTo);

        int ans = 0;
        int tmp = 2;
        for (int i = arr.size() - 1; i > 0; i -= 2) {
            if (arr.get(i) == 1 || arr.get(i - 1) == 1) {
                ans += arr.get(i) + arr.get(i - 1);
                tmp = i;
                continue;
            }
            ans += arr.get(i) * arr.get(i - 1);
            tmp = i;
        }

        if (tmp == 2 && !arr.isEmpty()) {
            ans += arr.get(0);
        }

        tmp = arr2.size() - 3;

        for (int i = 0; i < arr2.size() - 1; i += 2) {
            if (i + 1 == arr2.size()) {
                break;
            }
            ans += arr2.get(i) * arr2.get(i + 1);
            tmp = i;
        }

        if (tmp == arr2.size() - 3 && !arr2.isEmpty()) {
            ans += arr2.get(arr2.size() - 1);
        }

        System.out.println(ans);
    }
}