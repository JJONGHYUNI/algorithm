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
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;

        while (!meetings.isEmpty()) {
            Meeting meeting = meetings.poll();

            if (rooms.isEmpty() || meeting.start < rooms.peek()) {
                answer++;
                rooms.add(meeting.end);
                continue;
            }

            rooms.poll();
            rooms.add(meeting.end);
        }

        System.out.print(answer);
    }
}