import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        String ss = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] strings = ss.split("-");

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int num;
        String[] tmps;

        for (String tmp : strings) {
            tmps = tmp.split(",");

            for (String t : tmps) {
                num = Integer.parseInt(t);
                if (answer.contains(num)) {
                    continue;
                }

                answer.add(num);
            }
        }

        return answer;
    }
}