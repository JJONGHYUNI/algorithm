import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> meetings = new PriorityQueue<>();
        List<Integer> endTimes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int answer = 0;
        Meeting meeting = meetings.poll();
        endTimes.add(meeting.end);
        while (!meetings.isEmpty()) {
            meeting = meetings.poll();
            boolean control = false;
            for (int i = 0; i < endTimes.size(); i++) {
                if (meeting.start >= endTimes.get(i)) {
                    endTimes.set(i, meeting.end);
                    control = true;
                    break;
                }
            }

            if (control) {
                continue;
            }

            endTimes.add(meeting.end);
        }

        System.out.print(endTimes.size());
    }
}