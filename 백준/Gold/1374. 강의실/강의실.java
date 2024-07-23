import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    // 강의 start 순으로 정렬
    static class Lecture implements Comparable<Lecture> {

        int idx, start, end;
        
        public Lecture(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }
    
    // 강의실 end 순으로 정렬
    static class Room implements Comparable<Room> {

        int end;

        public Room(int end) {
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        Collections.sort(lectures);
        PriorityQueue<Room> q = new PriorityQueue<>();

        q.add(new Room(lectures.get(0).end));
        
        for (int i = 1; i < n; i++) {

            Lecture lecture = lectures.get(i);
            
            // 가장 빨리 끝나는 강의실이 남은 강의 시작 시간 중 가장 빠른 애보다 이하이면 그 강의실을 없애기.
            if (!q.isEmpty() && q.peek().end <= lecture.start) {
                q.poll();
            }
            
            // 강의실 추가
            q.add(new Room(lecture.end));
        }
        
        System.out.print(q.size());
    }
}
