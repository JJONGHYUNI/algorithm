
class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        int sum = 0;
        for(int number : numbers){
            sum+=number;
        }
        return answer-sum;
    }
}