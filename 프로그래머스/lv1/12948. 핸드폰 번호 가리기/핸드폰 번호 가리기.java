class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int size = phone_number.length();
        for(int i =0; i<size-4;i++){
            answer+="*";
        }
        for (int i = size-4;i<size;i++){
            answer+=phone_number.charAt(i);
        }
        return answer;
    }
}