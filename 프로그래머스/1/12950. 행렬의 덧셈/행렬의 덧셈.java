import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        List<int[]> answer = new ArrayList<>();
        for(int i = 0; i < arr1.length; i++){
            int[] temp = new int[arr1[i].length];
            for(int j = 0; j < arr1[i].length; j++){
                temp[j] = arr1[i][j] + arr2[i][j];
            }
            answer.add(temp);
        }
        return answer.toArray(new int[answer.size()][]);
    }
}