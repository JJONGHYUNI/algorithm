import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        Set<Integer> set= new HashSet<>();
        int[] arr =new int[len*2];
        for(int i=0; i<len*2; i++){
            arr[i]=elements[i%len];
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                int[] tmp=Arrays.copyOfRange(arr,i,i+j+1);
                int sum = Arrays.stream(tmp).sum();
                set.add(sum);
            }
        }
        return set.size();
    }
}