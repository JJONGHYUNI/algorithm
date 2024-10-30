import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String bomb = br.readLine();
        int bombSize = bomb.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() < bombSize) {
                continue;
            }

            boolean isSame = true;

            for (int j = 0; j < bombSize; j++) {
                if (stack.get(stack.size() - j - 1) == bomb.charAt(bombSize - j - 1)) {
                    continue;
                }

                isSame = false;
                break;
            }

            if (isSame) {
                for (int j = 0; j < bombSize; j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        System.out.print(stack.isEmpty() ? "FRULA" : sb);
    }
}
