import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    static Map<String, Integer> map = new HashMap<>();
    static char[] a, b;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void init() throws IOException {
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    private static void solution() {
        int num1 = convertStringToNumber(a);
        int num2 = convertStringToNumber(b);
        int ans = num1 + num2;
        System.out.println(ans);
        System.out.print(convertNumberToString(ans));
    }

    private static int convertStringToNumber(char[] arr) {
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (isExcludedChar(c) && i < arr.length - 1) {
                String s = "" + arr[i] + arr[i + 1];
                if (map.containsKey(s)) {
                    num += map.get(s);
                    i++;
                    continue;
                }
            }

            num += map.get(String.valueOf(c));
        }
        return num;
    }

    private static String convertNumberToString(int num) {

        StringBuilder s = new StringBuilder();
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1))));

        while (num != 0) {
            int tmp = 0;
            for (String key : keySet) {
                tmp = num / map.get(key);
                if (tmp > 0) {
                    s.append(String.valueOf(key).repeat(tmp));
                    num %= map.get(key);
                }
            }
        }

        return s.toString();
    }

    static List<Character> excludedChars = List.of('I', 'X', 'C');

    private static boolean isExcludedChar(char c) {
        return excludedChars.contains(c);
    }
}