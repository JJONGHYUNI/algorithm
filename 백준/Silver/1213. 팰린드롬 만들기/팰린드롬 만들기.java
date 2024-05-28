import java.io.*;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 'A';
            alpha[tmp] += 1;
        }

        int possible = 0;

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0) {
                possible += 1;
            }
        }

        if (possible > 1) {
            System.out.print("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < alpha.length; i++) {
            for (int r = 0; r < alpha[i] / 2; r++) {
                sb.append((char) (i + 65));
            }
        }
        String answer = "";
        answer += sb;
        String end = sb.reverse().toString();
        sb = new StringBuilder();
        for(int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 == 1) {
                sb.append((char) (i + 65));
            }
        }
        answer += sb + end;
        System.out.print(answer);

    }


}