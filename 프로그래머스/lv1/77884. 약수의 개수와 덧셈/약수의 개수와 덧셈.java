class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left;i<=right;i++){
            int yaksu=yaksuNum(i);
            System.out.println(yaksu);
            answer+=(yaksu%2==0)?i:(-i);
        }
        return answer;
    }
    private int yaksuNum(int num){
        int sum = 0;
        if (num==1){
            return 1;
        }
        for (int i = 2; i<num;i++){
            sum+=(num%i==0) ? 1 : 0;
        }
        return sum+2;
    }
}