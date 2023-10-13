class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0 ;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(!Character.isAlphabetic(temp)){
                answer += temp;
                idx = 0;
                continue;
            }
            if(isEvenNum(idx)){
                answer += Character.toUpperCase(temp);
                idx += 1;
                continue;
            }
            idx += 1;
            answer += Character.toLowerCase(temp);
        }
        return answer;
    }
    private static boolean isEvenNum(int check){
        return check == 0 || check % 2 == 0 ;
    }
}