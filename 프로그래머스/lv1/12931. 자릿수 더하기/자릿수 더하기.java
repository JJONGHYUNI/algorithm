import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String[] to=Integer.toString(n).split("");
        for (int i = 0; i<to.length; i++){
            answer+=Integer.parseInt(to[i]);
        }

        return answer;
    }
}