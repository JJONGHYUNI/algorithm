import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        while (s.length() < t.length()) {
            int len = t.length();
            if (t.charAt(len - 1) == 'A') {
                t.deleteCharAt(len - 1);
            } else if (t.charAt(len - 1) == 'B') {
                t.deleteCharAt(len - 1);
                t.reverse();
            }
        }
        System.out.print(s.equals(t.toString()) ? 1 : 0);

    }
}
