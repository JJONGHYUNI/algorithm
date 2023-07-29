class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str = Integer.toString(x);
        char[] arr = str.toCharArray();
        int temp=0;
        for(char i : arr){
            int tmp = Character.getNumericValue(i);
            temp+=tmp;
        }
        if(x%temp!=0){
            answer = false;
        }
        return answer;
    }
}