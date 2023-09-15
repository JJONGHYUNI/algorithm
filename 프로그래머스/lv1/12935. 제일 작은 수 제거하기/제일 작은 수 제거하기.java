import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length-1;
        if(len==0){
            int[] answer={-1};
            return answer;
        }
        int[] answer=new int[len];
        int min = 999999999;
        int idx= 0;
        for (int i = 0 ; i <= len; i++){
            if(min>arr[i]){
                min=arr[i];
                idx=i;
            }
        }
        for (int i = 0 ; i<idx; i++){
            answer[i]=arr[i];
        }
        for (int i = idx+1; i<=len; i++){
            answer[i-1]=arr[i];
        }
        return answer;
    }
}