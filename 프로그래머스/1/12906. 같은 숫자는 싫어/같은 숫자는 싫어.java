import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int len = arr.length;
        try{
            for(int i = 0; i < len - 1; i++){
                if (arr[i] != arr[i+1]){
                    answer.add(arr[i]);
                }
            }
            if(arr[arr.length - 1] != answer.get(answer.size() - 1)){
                answer.add(arr[arr.length - 1]);
            }
        }catch(RuntimeException e){
            answer.add(arr[0]);
        }
        return listToIntArray(answer);
    }
    
    private int[] listToIntArray(List<Integer> intArr){
        int[] result = new int[intArr.size()];
        for(int i = 0; i<intArr.size(); i++){
            result[i] = intArr.get(i);
        }
        return result;
    }
}