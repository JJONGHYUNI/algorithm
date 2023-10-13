import java.util.*;

class Solution {
    public int solution(int n) {
        long three = convertToThreeAndReverse(n);
        long answer = convertToDemical(Long.toString(three));
        return (int) answer;
    }
    private long convertToThreeAndReverse(long n){
        String result = "";
        while(n / 3 != 0){
            result += Long.toString(n % 3);
            n /= 3;
        }
        result += Long.toString(n%3);
        
        return Long.parseLong(result);
    }
    private long convertToDemical(String str){
        long result = 0 ;
        for(int i = 0; i < str.length(); i++){
            int temp = (int) Math.pow(3, i);
            result += temp * (int) (str.charAt(str.length() - 1 - i) - '0');
        }
        return result;
    }
}