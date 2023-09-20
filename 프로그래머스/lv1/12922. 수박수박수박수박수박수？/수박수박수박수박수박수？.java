class Solution {
    public String solution(int n) {
        String answer = "";
        String watermelon="수박";
        int devide=n/2;
        int remain=n%2;
        answer=watermelon.repeat(devide);
        if(remain==1){
            answer+="수";
        }
        return answer;
    }
}