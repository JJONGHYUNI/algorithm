class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] mods = new String[]{"aya", "ye", "woo", "ma"};
        String[] answers = new String[]{" ", "  ", "   ", "    "};
        for (String s : babbling) {
            for (String mod : mods) {
                s = s.replace(mod, " ");
            }

            for (String a : answers) {
                if (s.equals(a)) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}