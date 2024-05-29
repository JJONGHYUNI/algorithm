import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] students = new int[n];

        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        int[] differences = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            differences[i] = students[i + 1] - students[i];
        }

        Arrays.sort(differences);

        int answer = 0;

        for (int i = 0; i < n - k; i++) {
            answer += differences[i];
        }

        System.out.print(answer);
    }
}