import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 맨 왼쪽 위 흰색일 때 , 검정색일 때 각각 누적합
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        String[] ips = s.split(":");
        Queue<String> after = new ArrayDeque<>();
        List<String> iplist = new ArrayList<>();
        int control = 0;
        for (String ip : ips) {
            if (ip.length() == 4) {
                if (control == 1) {
                    after.add(ip);
                    continue;
                }
                iplist.add(ip);
                continue;
            }

            if (ip.length() == 0) {
                if (control == 1) {
                    after.add("0000");
                    continue;
                }
                iplist.add("0000");
                control += 1;
                continue;
            }

            String tmpIp = "";

            for (int i = 0; i < 4 - ip.length(); i++) {
                tmpIp += 0;
            }
            if (control == 1) {
                after.add(tmpIp + ip);
                continue;
            }
            iplist.add(tmpIp + ip);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iplist.size(); i++) {
            sb.append(iplist.get(i)).append(":");
        }

        for (int i = 0; i < 8 - iplist.size() - after.size(); i++) {
            sb.append("0000").append(":");
        }

        while (!after.isEmpty()) {
            sb.append(after.poll()).append(":");
        }

        if (sb.toString().length() == 40) {
            sb = new StringBuilder(sb.toString().substring(0, sb.toString().length() - 1));
        }

        if (sb.toString().length() > 40) {
            sb = new StringBuilder(sb.toString().substring(5, sb.toString().length() - 1));
        }
        System.out.print(sb);
    }
}