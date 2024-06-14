import java.io.*;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // a1 = 2, a2 = 3, a3 = 4, a4 = 5, a5 = 5, a6 = 7, a7 = 7
    static long n;
    static int p, q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        System.out.print(recursive(n));
    }

    private static long recursive(long num) {
        if (num == 0) {
            return 1;
        }
        
        if (map.containsKey(num)) {
            return map.get(num);
        }

        long a = (long) Math.floor(num / p);
        long b = (long) Math.floor(num / q);

        map.put(num, recursive(a) + recursive(b));
        return map.get(num);
    }
}