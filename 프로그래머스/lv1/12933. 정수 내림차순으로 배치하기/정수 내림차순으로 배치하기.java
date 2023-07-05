import java.util.*;
class Solution {
    public long solution(long n) {
        String s = ""+n;
        Integer[] arr = new Integer[s.length()];
        for(int i = 0; i<s.length();i++){
            arr[i]=(int)(n%10);
            n/=10;
        }
        Arrays.sort(arr,Collections.reverseOrder());
        String answer = Arrays.toString(arr).replaceAll("[^0-9]","");
        return Long.parseLong(answer);
    }
}