import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }

        int[] alphabets = new int[26];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                alphabets[word.charAt(i) - 'A'] += (int) Math.pow(10, word.length() - i - 1);
            }
        }

        Arrays.sort(alphabets);

        int tmp = 9;
        int ans = 0;

        for (int i = alphabets.length - 1; i >= 0; i--) {
            if (alphabets[i] == 0) {
                break;
            }

            ans += alphabets[i] * tmp--;
        }

        System.out.print(ans);
    }
}