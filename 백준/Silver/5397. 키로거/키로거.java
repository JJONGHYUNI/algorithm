import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split("");
            int len = s.length;
            Stack<String> l = new Stack<>();
            Stack<String> r = new Stack<>();

            for (String c: s) {
                switch (c) {
                    case "<":
                        if (!l.isEmpty()) {
                            r.add(l.pop());
                        }
                        break;
                    case  ">":
                        if (!r.isEmpty()) {
                            l.add(r.pop());
                        }
                        break;
                    case "-":
                        if(!l.isEmpty()) {
                            l.pop();
                        }
                        break;
                    default:
                        l.add(c);
                }
            }
            for (String c : l) {
                sb.append(c);
            }
            while(!r.isEmpty()) {
                sb.append(r.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}