import java.io.*;
import java.util.*;

class Main {

    static  char[][] words;
    static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        words = new char[r][c];
        for (int i = 0; i < r; i++) {
            words[i] = br.readLine().toCharArray();
        }

        int cnt = binarySearch();
        System.out.print(cnt);
    }

    private static int binarySearch() {
        int l = 0, r = words.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (isValid(mid)) {
                l = mid + 1;
                continue;
            }

            r = mid - 1;
        }

        return l;
    }

    private static boolean isValid(int mid) {
        Set<String> set = new HashSet<>();
        String tmp;
        for (int i = 0; i < c; i++) {
            tmp = "";
            for (int j = mid + 1; j < r; j++) {
                tmp += words[j][i];
            }

            if (set.contains(tmp)) {
                return false;
            }

            set.add(tmp);
        }
        return true;
    }
}